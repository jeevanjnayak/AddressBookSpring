package com.person.addressbook.service;

import com.person.addressbook.dto.PersonDTO;
import com.person.addressbook.entity.Person;
import com.person.addressbook.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServices implements IAddressBookServices {

    @Autowired
    IPersonRepository iPersonRepository;
    @Override
    public Person addPerson(PersonDTO personDTO) {

        Person person = new Person(personDTO);
        return iPersonRepository.save(person);
    }

    @Override
    public List<Person> getAddressBook() {
        return iPersonRepository.findAll();
    }

    @Override
    public Optional<Person> getById(int id) {
        return iPersonRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        if (iPersonRepository.findById(id).isPresent()) {
            iPersonRepository.deleteById(id);
            return "Employee ID: " + id + " is Deleted!";
        }
        return "Employee not present!";
    }

    @Override
    public String editEmployee(PersonDTO personDTO, int id) {
        if (iPersonRepository.findById(id).isPresent()) {
            Person person = new Person(personDTO , id);
            person.setId(id);
            Person string = iPersonRepository.save(person);
            return string.toString();
        }
        return null;
    }

    @Override
    public List<Person> getPersonByCity(String city) {

        return iPersonRepository.findByCity(city);
    }
}
