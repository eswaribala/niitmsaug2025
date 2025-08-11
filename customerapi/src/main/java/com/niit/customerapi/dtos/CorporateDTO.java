package com.niit.customerapi.dtos;

import com.niit.customerapi.models.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class CorporateDTO extends CustomerDTO implements Serializable {


    private CompanyType companyType;
}
