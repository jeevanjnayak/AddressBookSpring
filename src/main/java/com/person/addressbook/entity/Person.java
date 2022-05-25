package com.person.addressbook.entity;

import com.person.addressbook.dto.PersonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "citys")
    private List<String> city;
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
