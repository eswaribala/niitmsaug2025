package com.niit.customerapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy=InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Account_No")
    protected long accountNo;

    @Embedded
    protected  FullName fullName;
    @Column(name="Email",nullable = false,length = 150, unique = true)
    protected  String email;

    @Column(name="Password",nullable = false,length = 10)
    protected  String password;
    @Column(name="Phone_Number")
    protected  long phoneNumber;

}
