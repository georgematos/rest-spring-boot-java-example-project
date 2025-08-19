package com.gcorp.services;

import com.gcorp.exception.ResourceNotFoundException;
import com.gcorp.data.dto.PersonDTO;
import static com.gcorp.mapper.ObjectMapper.parseListObjects;
import static com.gcorp.mapper.ObjectMapper.parseObject;

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

    public PersonDTO findPersonById(Long id) {
        logger.info("Finding one PersonDTO...");
        return parseObject(respository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No record found by ID: " + id)), PersonDTO.class
        );
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all Persons...");
        return parseListObjects(respository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating a new person...");
        var entity = parseObject(person, Person.class);
        return parseObject(respository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating a person...");
        Person entity = respository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No record found by this ID")
        );
        entity.setName(person.getName());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        var persistedEntity = respository.save(entity);
        return parseObject(persistedEntity, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Removing a person... " + id);
        respository.deleteById(id);
    }
}
