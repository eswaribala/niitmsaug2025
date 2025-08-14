package com.niit.accountapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class CustomerDTO implements Serializable {

    protected long accountNo;

    protected FullNameDTO fullName;


    protected  String email;


    protected  String password;


    protected  long phoneNumber;

}
