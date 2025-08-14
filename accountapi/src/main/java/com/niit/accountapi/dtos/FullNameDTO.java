package com.niit.accountapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullNameDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String middleName;
}
