package com.gcorp.controllers;

import com.gcorp.model.Person;
import com.gcorp.services.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    @ResponseBody
    public Person findPersonById(@PathVariable Long id) {
        return service.findPersonById(id);
    }

    @GetMapping
    @ResponseBody
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseBody
    public Person post(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping
    @ResponseBody
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
