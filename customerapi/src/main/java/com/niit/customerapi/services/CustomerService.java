package com.niit.customerapi.services;

import com.niit.customerapi.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer updateCustomer(long accountNo, String newEmail);
    boolean deleteCustomer(long accountNo);
    Customer findCustomer(long accountNo);
}
