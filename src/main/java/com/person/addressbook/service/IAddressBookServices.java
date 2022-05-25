package com.person.addressbook.service;


import com.person.addressbook.dto.PersonDTO;
import com.person.addressbook.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IAddressBookServices {
    Person addPerson(PersonDTO personDTO);

    List<Person> getAddressBook();

    Optional<Person> getById(int id);

    String deleteById(int id);

    String editEmployee(PersonDTO employeeDto, int id);

    List<Person> getPersonByCity(String city);
}
