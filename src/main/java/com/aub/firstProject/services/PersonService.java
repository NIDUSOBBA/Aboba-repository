package com.aub.firstProject.services;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.models.Person;
import com.aub.firstProject.repositories.PersonRepository;
import com.aub.firstProject.util.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PersonService {
    private final PersonRepository personRepository;

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

    public Person findById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public PersonDto updateStatus(String email, String status) {
        var byEmail = findByEmail(email);
        var status1 = byEmail.getStatus();
        byEmail.setStatus(status);
        var personDto = PersonConverter.convertPersonDto(byEmail);
        personRepository.save(byEmail);
        if(status1 == null){
            personDto.setStatus(status+"The previous status was Null");
            return personDto;
        }else {
            personDto.setStatus(status +"The previous status was " + status1);
            return personDto;
        }
    }

}
