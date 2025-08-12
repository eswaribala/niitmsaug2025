package com.niit.customerapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO implements Serializable {

    private long addressId;

    private String doorNo;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private CustomerDTO customer;
}
