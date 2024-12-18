package com.aub.firstProject.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private String image;

    private String fullName;

    private Integer age;

    @Email
    private String email;

    private String status;

}
