package com.niit.customerapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must contain only alphabets")

    private String firstName;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must contain only alphabets")

    private String lastName;

    private String middleName;
}
