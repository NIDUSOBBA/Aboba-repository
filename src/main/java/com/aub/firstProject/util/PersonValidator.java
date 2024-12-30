package com.aub.firstProject.util;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonDto personDto = (PersonDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "field.required", "Name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Name cannot be empty");

        if(personDto.getFullName().length() < 2){
            errors.rejectValue("fullName", "field.required", "Name must be at least 2 characters");
        }
        if(personService.findByEmail(personDto.getEmail()) != null){
            errors.rejectValue("email", "field.required", "Email is already in use");
        }
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
