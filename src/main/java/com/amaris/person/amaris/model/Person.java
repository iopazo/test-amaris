package com.amaris.person.amaris.model;

import com.amaris.person.amaris.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "document_type")
    private String documentType;
    @Column (name = "document_number")
    private Long documentNumber;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "second_name")
    private String secondName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "mother_lastname")
    private String motherLastName;
    @Column (name = "phone_number")
    private String phoneNumber;
    private String address;
    private String city;

    public Person(Long id, String documentType, Long documentNumber, String firstName, String secondName, String lastName, String motherLastName, String phoneNumber, String address, String city) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
    }

    public Person() {

    }

    public Person(PersonDTO person) {
        this.id = person.getId();
        this.documentType = person.getDocumentType();
        this.documentNumber = person.getDocumentNumber();
        this.firstName = person.getFirstName();
        this.secondName = person.getSecondName();
        this.lastName = person.getLastName();
        this.motherLastName = person.getMotherLastName();
        this.phoneNumber = person.getPhoneNumber();
        this.address = person.getAddress();
        this.city = person.getCity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
