package com.aub.firstProject.repositories;

import com.aub.firstProject.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByEmail(String email);
    public List<Person> findByStatus(String status);
}
