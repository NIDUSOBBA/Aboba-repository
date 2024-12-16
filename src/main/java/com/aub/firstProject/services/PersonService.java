package com.aub.firstProject.services;

import com.aub.firstProject.models.Person;
import com.aub.firstProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        personRepository.save(person);
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

}
