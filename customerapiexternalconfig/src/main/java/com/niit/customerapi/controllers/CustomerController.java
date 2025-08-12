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


    @GetMapping("/v1.0/{accountNo}")
    public ResponseEntity<ResponseWrapper> fetchCustomerById(@PathVariable("accountNo") long accountNo){
        Customer customer= customerService.findCustomer(accountNo);

        if(customer != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Customer>(customer));
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper("Customer not found"));


    }

    @PutMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestParam("accountNo") long accountNo,@RequestParam("newEmail") String newEmail){
        Customer customer= customerService.updateCustomer(accountNo, newEmail);

        if(customer != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Customer>(customer));
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper("Customer not updated"));


    }

    @DeleteMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> deleteCustomer(@RequestParam("accountNo") long accountNo){

        if(customerService.deleteCustomer(accountNo)){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("Customer deleted"));
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper("Customer not deleted"));


    }
}
