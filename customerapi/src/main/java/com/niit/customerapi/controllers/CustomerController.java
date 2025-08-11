package com.niit.customerapi.controllers;

import com.niit.customerapi.dtos.CustomerDTO;
import com.niit.customerapi.dtos.ResponseWrapper;
import com.niit.customerapi.models.Customer;
import com.niit.customerapi.models.FullName;
import com.niit.customerapi.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){

        Customer customer = Customer.builder()
                .accountNo(customerDTO.getAccountNo())
                .fullName(FullName.builder().firstName(customerDTO.getFullName().getFirstName())
                .lastName(customerDTO.getFullName().getLastName())
                        .middleName(customerDTO.getFullName().getMiddleName())
                        .build())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .phoneNumber(customerDTO.getPhoneNumber())

                .build();

       Customer savedCustomer= customerService.addCustomer(customer);

       if(savedCustomer != null){
           return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Customer>(savedCustomer));
       }else
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer could not be saved"));

    }


    @GetMapping("/v1.0")
    public List<Customer> fetchCustomers(){
        return customerService.getCustomers();
    }
}
