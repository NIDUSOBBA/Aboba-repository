package com.aub.firstProject.service;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.models.Person;
import com.aub.firstProject.repository.PersonRepository;
import com.aub.firstProject.util.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
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
        var personDto = personMapper.mapPersonDto(byEmail);
        byEmail.setUpdateStatus(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        personRepository.save(byEmail);
        if (status1 == null) {
            personDto.setStatus(status + "The previous status was Null");
            return personDto;
        } else {
            personDto.setStatus(status + "The previous status was " + status1);
            return personDto;
        }
    }

    public List<PersonDto> findAllForStatus(String status, String from) {
        List<Person> byStatus;
        if (status.equals("offline") || status.equals("online")) {
            byStatus = personRepository.findByStatus(status);
        } else {
            byStatus = personRepository.findAll();
        }

        List<PersonDto> personDtos = new ArrayList<>();

        for (Person person : byStatus) {

            if (from.equals(" ")) {
                if (person.getUpdateStatus().toString().equals(from)) {
                    personDtos.add(personMapper.mapPersonDto(person));
                }
            } else {
                personDtos.add(personMapper.mapPersonDto(person));
            }
        }
        return personDtos;
    }

}
