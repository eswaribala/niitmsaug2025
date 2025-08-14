package com.niit.customerapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.niit.customerapi.models.Customer;
import org.springframework.kafka.support.SendResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer updateCustomer(long accountNo, String newEmail);
    boolean deleteCustomer(long accountNo);
    Customer findCustomer(long accountNo);

    CompletableFuture<SendResult<Object,Object>> publishCustomerData(Customer customer) throws JsonProcessingException;

}
