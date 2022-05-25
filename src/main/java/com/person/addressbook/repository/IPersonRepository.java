package com.person.addressbook.repository;

import com.person.addressbook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM person e, city ed WHERE e.id = ed.id AND ed.citys = :city",nativeQuery = true)
    List<Person> findByCity(String city);
}
