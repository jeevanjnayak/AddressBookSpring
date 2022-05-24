package com.person.addressbook.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class PersonDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]+$", message = "Name is invalid! it must have at least 2 characters and the first character should be uppercase.")
    private String name;

    @NotEmpty(message = "Profile pic can't be empty")
    private String profilePic;

    @NotEmpty(message = "Its a required field! can't be empty")
    private String gender;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "txycy")
    private String mobileNumber;

    @Email
    private String email;

    @NotEmpty(message = "Please enter the address")
    private String address;

    @NotEmpty(message = "Please enter the city")
    private String city;

    private LocalDate dob;
    private String notes;
}
