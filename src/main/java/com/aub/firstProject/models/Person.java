package com.aub.firstProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
