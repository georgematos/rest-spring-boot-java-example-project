package com.gcorp.services;

import com.gcorp.exception.ResourceNotFoundException;
import com.gcorp.model.Person;
import com.gcorp.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonService {

    @Autowired
    private PersonRepository respository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public Person findPersonById(Long id) {
        logger.info("Finding one Person...");
        return respository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No record found by ID: " + id)
        );
    }

    public List<Person> findAll() {
        logger.info("Finding all Persons...");
        return respository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating a new person...");
        return respository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating a person...");
        Person current_person = respository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No record found by this ID")
        );
        current_person.setName(person.getName());
        current_person.setLastname(person.getLastname());
        current_person.setAddress(person.getAddress());
        return respository.save(current_person);
    }

    public void delete(Long id) {
        logger.info("Removing a person... " + id);
        respository.deleteById(id);
    }
}
