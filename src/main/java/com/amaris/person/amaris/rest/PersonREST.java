package com.amaris.person.amaris.rest;

import com.amaris.person.amaris.dto.PersonDTO;
import com.amaris.person.amaris.model.Person;
import com.amaris.person.amaris.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("/api/person")
public class PersonREST {
    Logger logger = LoggerFactory.getLogger(PersonREST.class);

    @Autowired
    private PersonService service;

    @PostMapping
    private ResponseEntity<PersonDTO> save(@RequestBody PersonDTO person) {

        if (!validateDocumentType(person.getDocumentType())) {
            logger.info("Document Type: " + person.getDocumentType());
            throw new IllegalArgumentException();
        }

        Person personToDTO = new Person(person);
        try {
            service.create(personToDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/findByDocumentTypeAndNumber")
    private ResponseEntity<List<Person>> getPersonByTypeAndDocumentNumber(@RequestParam String documentType, @RequestParam Long documentNumber) {

        if (!validateDocumentType(documentType)) {
            logger.info("Document Type: " + documentType);
            throw new IllegalArgumentException();
        }
        try {
            return ResponseEntity.ok(service.findByDocumentAndNumber(documentType, documentNumber));
        }
        catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private boolean validateDocumentType(String documentType) {
        String[] documents = {"P", "C"};
        List<String> list = Arrays.asList(documents);
        return list.contains(documentType);
    }

}
