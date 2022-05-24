package com.person.addressbook.entity;

import com.person.addressbook.dto.PersonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@ToString
@RequiredArgsConstructor

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String profilePic;

    private String gender;
    private String mobileNumber;
    private String email;

    private String address;

    private String city;
    private LocalDate dob;
    private String notes;

    public Person(PersonDTO personDTO) {
        this.name = personDTO.getName();
        this.profilePic = personDTO.getProfilePic();
        this.gender = personDTO.getGender();
        this.mobileNumber = personDTO.getMobileNumber();
        this.email = personDTO.getEmail();
        this.address = personDTO.getAddress();
        this.city = personDTO.getCity();
        this.dob = personDTO.getDob();
        this.notes = personDTO.getNotes();
    }

    public Person(PersonDTO personDTO, int id) {
        this.name = personDTO.getName();
        this.profilePic = personDTO.getProfilePic();
        this.gender = personDTO.getGender();
        this.mobileNumber = personDTO.getMobileNumber();
        this.email = personDTO.getEmail();
        this.address = personDTO.getAddress();
        this.city = personDTO.getCity();
        this.dob = personDTO.getDob();
        this.notes = personDTO.getNotes();
        this.id = id;
    }
}
