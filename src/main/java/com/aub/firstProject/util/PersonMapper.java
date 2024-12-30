package com.aub.firstProject.util;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public Person mapPerson(PersonDto personDTO) {
        Person person = new Person();
        person.setImage(personDTO.getImage());
        person.setFullName(personDTO.getFullName());
        person.setAge(personDTO.getAge());
        person.setEmail(personDTO.getEmail());
        return person;
    }

    public PersonDto mapPersonDto(Person person) {
        PersonDto personDTO = new PersonDto();
        personDTO.setImage(person.getImage());
        personDTO.setFullName(person.getFullName());
        personDTO.setAge(person.getAge());
        personDTO.setEmail(person.getEmail());
        personDTO.setStatus(person.getStatus());
        return personDTO;
    }
}
