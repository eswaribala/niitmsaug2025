package com.niit.customerapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName implements Serializable {
    @Column(name="First_Name",nullable=false,length=50)
    @Schema(description = "First name value", example = "")
    private String firstName;
    @Column(name="Last_Name",nullable=false,length=50)
    @Schema(example = "")
    private String lastName;
    @Column(name="Middle_Name",nullable=true,length=50)
    private String middleName;
}
