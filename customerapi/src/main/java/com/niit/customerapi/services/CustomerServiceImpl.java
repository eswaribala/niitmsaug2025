package com.niit.customerapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import com.niit.customerapi.exceptions.CustomerNotFoundException;
import com.niit.customerapi.models.Customer;
import com.niit.customerapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    @Value("${topicName}")
    private String topicName;

    @Autowired
    private CustomerRepository  customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        if(customer!=null){
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(long accountNo, String newEmail) {
       Customer customer=findCustomer(accountNo);
       if(customer!=null){
           customer.setEmail(newEmail);
           return customerRepository.save(customer);
       }else {
           return null;
       }
    }

    @Override
    public boolean deleteCustomer(long accountNo) {
        boolean status=false;
        Customer customer=findCustomer(accountNo);
        if(customer!=null){
            customerRepository.delete(customer);
            status=true;
        }
        return status;
    }

    @Override
    public Customer findCustomer(long accountNo) {
        return customerRepository.findById(accountNo).orElseThrow(()->
                new CustomerNotFoundException("Customer with account number "+accountNo+" not found"));
    }

    @Override
    public CompletableFuture<SendResult<Object, Object>> publishCustomerData(Customer customer) throws JsonProcessingException {
       Faker faker = new Faker();
       customer.setAccountNo(faker.number().numberBetween(10000,100000));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(customer);
        //publishing the data
        return  kafkaTemplate.send(topicName,json);


    }
}
