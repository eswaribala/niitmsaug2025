package com.niit.customerapi.dtos;

import com.niit.customerapi.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;


@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class IndividualDTO extends CustomerDTO implements Serializable {

    private Gender gender;

    private LocalDate dateOfBirth;

}
