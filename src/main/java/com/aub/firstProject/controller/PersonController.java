package com.aub.firstProject.controller;

import com.aub.firstProject.dto.PersonDTO;
import com.aub.firstProject.models.Person;
import com.aub.firstProject.services.PersonService;
import com.aub.firstProject.util.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public String newPerson(@RequestBody PersonDTO personDTO) {
        Person person = PersonConverter.convertPerson(personDTO);
        personService.save(person);
        return "Id нового пользователя" + personService.findByEmail(personDTO.getEmail()).getId();
    }
}
