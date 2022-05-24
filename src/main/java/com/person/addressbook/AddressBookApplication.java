package com.person.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class AddressBookApplication {

    public static void main(String[] args) {

        SpringApplication.run(AddressBookApplication.class, args);
        System.out.println("Hello Person");
        log.info("Hello Jeevan");
    }

}
