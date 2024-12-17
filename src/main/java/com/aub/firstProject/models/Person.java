package com.aub.firstProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String image;

    @Column
    private String fullName;

    @Column
    private int age;

    @Column
    @Email
    private String email;

    @Column
    private LocalDateTime createdAt;

    public Person() {
    }

    public Person(String image, String fullName, int age, String email) {
        this.image = image;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

}
