package com.niit.customerapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName {
    @Column(name="First_Name",nullable=false,length=50)
    private String firstName;
    @Column(name="Last_Name",nullable=false,length=50)
    private String lastName;
    @Column(name="Middle_Name",nullable=true,length=50)
    private String middleName;
}
