package com.niit.customerapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;
    @Column(name="Door_No",nullable=false,length=5)
    private String doorNo;
    @Column(name="Street_Name",nullable=false,length=150)
    private String street;
    @Column(name="City",nullable=false,length=50)
    private String city;
    @Column(name="State",nullable=false,length=50)
    private String state;
    @Column(name="ZipCode",nullable=false,length=8)
    private String zip;
    @Column(name="Country",nullable=false,length=50)
    private String country;
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Account_No"),
            name = "Account_No_FK")

    private Customer customer;
}
