package com.amaris.person.amaris.service;

import com.amaris.person.amaris.dto.PersonDTO;
import com.amaris.person.amaris.model.Person;
import com.amaris.person.amaris.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public List<Person> findByDocumentAndNumber (String documentType, Long documentNumber) {
        return repository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
    }
}
