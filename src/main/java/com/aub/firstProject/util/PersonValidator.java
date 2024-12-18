package com.aub.firstProject.util;

import com.aub.firstProject.dto.PersonDto;
import com.aub.firstProject.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
           throw new IllegalArgumentException("Full name must be at least 2 characters");
        }
        if(personService.findByEmail(personDto.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }

    }
}
