package com.person.addressbook.controller;

import com.person.addressbook.dto.PersonDTO;
import com.person.addressbook.dto.ResponseDTO;
import com.person.addressbook.entity.Person;
import com.person.addressbook.service.IAddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/person")
public class AddressBookController {
    @Autowired
    IAddressBookServices iAddressBookServices;

    //adding an employee and saving to DB using post mapping and taking the input by RequestBody
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody PersonDTO personDTO) {
        Person person = iAddressBookServices.addPerson(personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee added Successfully", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //getting all the employee and showing in a list form from the DB using get mapping
    @GetMapping("/showall")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        ResponseDTO responseDTO = new ResponseDTO("Employee List shown Bellow", iAddressBookServices.getAddressBook());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //getting the employee with a particular id from the DB and showing using get mapping
    @GetMapping("/show/{id}")
    public ResponseEntity<ResponseDTO> getByEmployee(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Shown bellow", iAddressBookServices.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //deleting the employee with a particular id from the DB using Delete mapping
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Deleted Successfully", iAddressBookServices.deleteById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //getting the employee with a particular id from the DB and updating the data and storing to DB using put mapping
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody PersonDTO employeeDto, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Updated Successfully", iAddressBookServices.editEmployee(employeeDto, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getPersonByCity(@PathVariable String city){
        List<Person> personList = iAddressBookServices.getPersonByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("employee list gotten successfully",personList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
