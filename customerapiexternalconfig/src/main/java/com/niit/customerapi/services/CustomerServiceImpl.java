package com.niit.customerapi.services;

import com.niit.customerapi.exceptions.CustomerNotFoundException;
import com.niit.customerapi.models.Customer;
import com.niit.customerapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

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
}
