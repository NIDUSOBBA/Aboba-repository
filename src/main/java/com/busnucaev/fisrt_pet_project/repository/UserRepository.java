package com.busnucaev.fisrt_pet_project.repository;

import com.busnucaev.fisrt_pet_project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
