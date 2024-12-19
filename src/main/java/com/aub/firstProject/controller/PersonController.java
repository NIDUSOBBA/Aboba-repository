package com.aub.firstProject.controller;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.services.PersonService;
import com.aub.firstProject.util.PersonConverter;
import com.aub.firstProject.util.PersonValidator;
import com.aub.firstProject.util.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonValidator(personService));
    }

    @PostMapping("/add")
    public String newPerson(@RequestBody PersonDto personDTO,
                            BindingResult bindingResult) {
        Timer.timerFiveSeconds();
        if (bindingResult.hasErrors()) {
            return String.valueOf(ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST));
        }
        personService.save(PersonConverter.convertPerson(personDTO));
        return "Id нового пользователя" + personService.findByEmail(personDTO.getEmail()).getId();
    }

    @GetMapping("/get")
    public PersonDto getPersonById(@RequestParam("id") Integer id) {
        return PersonConverter.convertPersonDto(personService.findById(id));
    }

    @GetMapping("/get_everyone_with")
    public List<PersonDto> getPersonWithEveryone(@RequestParam(value = "status", required = false) String status,
                                                 @RequestParam(value = "update_status", required = false) String localDateTime) {
        var allForStatus = personService.findAllForStatus(status, localDateTime);
        for (var person : allForStatus) {
            System.out.println(person.getImage());
            System.out.println(person.getFullName());
            System.out.println(person.getAge());
            System.out.println(person.getEmail());
            System.out.println(person.getStatus());
            System.out.println("_____");
        }
        return allForStatus;
    }

    @GetMapping("/update_status")
    public PersonDto updatePerson(@RequestParam("email") String email, @RequestParam("status") String status) {
        Timer.timerFiveSeconds();
        return personService.updateStatus(email, status);
    }
}
