package com.example.estudoSpringDataJdbc.controller;

import com.example.estudoSpringDataJdbc.model.Person;
import com.example.estudoSpringDataJdbc.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<?> personGET() {
        log.trace("START: GET /api/person");
        List<Person> personByFirstName = personRepository.findByFirstName("guilherme");

        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> personList = StreamSupport.stream(personIterable.spliterator(), false)
                .collect(Collectors.toList());

        boolean b = personRepository.create("Gui", "Test");

        log.trace("END: GET /api/person");
        return ResponseEntity.ok("OK!");
    }
}
