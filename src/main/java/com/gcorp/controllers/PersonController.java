package com.gcorp.controllers;

import com.gcorp.data.dto.PersonDTO;
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
    public PersonDTO findPersonById(@PathVariable Long id) {
        return service.findPersonById(id);
    }

    @GetMapping
    @ResponseBody
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseBody
    public PersonDTO post(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping
    @ResponseBody
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
