package com.amaris.person.amaris.repository;

import com.amaris.person.amaris.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByDocumentTypeAndDocumentNumber(String documentType, Long documentNumber);
}
