package com.niit.customerapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Schema(hidden = true)
    protected long accountNo;

    protected FullNameDTO fullName;

    @Email(message = "Enter valid mail address")
    protected  String email;
    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{5,10}$",message = "Password must have mininum one digit,one lowercase and one upper case")

    protected  String password;

    @Pattern(regexp = "^\\d{10}$",message = "Phone Number Should be in 10 Digits")

    protected  long phoneNumber;

}
