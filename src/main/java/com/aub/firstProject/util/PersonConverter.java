package com.aub.firstProject.util;

import com.aub.firstProject.dto.PersonDTO;
import com.aub.firstProject.models.Person;

public class PersonConverter {

    public static Person convertPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setImage(personDTO.getImage());
        person.setFullName(personDTO.getFullName());
        person.setAge(personDTO.getAge());
        person.setEmail(personDTO.getEmail());
        return person;
    }
}
