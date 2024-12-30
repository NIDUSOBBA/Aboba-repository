package com.aub.firstProject.controller;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.service.PersonService;
import com.aub.firstProject.util.PersonMapper;
import com.aub.firstProject.util.PersonValidator;
import com.aub.firstProject.util.Waiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @Autowired
    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    // проверить как работает эта штука, продеьажить до спринговых внутренних классов, проверить вообще вызывается ли это
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonValidator(personService));
    }

    @PostMapping("/add")
    public String newPerson(@RequestBody @Validated PersonDto personDTO,
                            BindingResult bindingResult) {
        Waiting.waitFiveSeconds();
        personService.save(personMapper.mapPerson(personDTO));
        return "Id нового пользователя" + personService.findByEmail(personDTO.getEmail()).getId();
    }

    // что такое CGLIB и Proxy и как их спринг исполоьзует
    @GetMapping("/get")
    public PersonDto getPersonById(@RequestParam("id") Integer id) {
        return personMapper.mapPersonDto(personService.findById(id));
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
        Waiting.waitFiveSeconds();
        return personService.updateStatus(email, status);
    }
}
