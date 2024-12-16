package com.aub.firstProject.repositories;

import com.aub.firstProject.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByEmail(String email);
}
