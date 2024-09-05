package com.busnucaev.fisrt_pet_project;

import com.busnucaev.fisrt_pet_project.entity.User;
import com.busnucaev.fisrt_pet_project.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

		var userRepository = context.getBean(UserRepository.class);
		User user = new User();
		user.setId(1L);
		user.setUsername("Djon");
		user.setPassword("password");
		user.setFirstName("John");
		user.setLastName("Smith");

		var saved = userRepository.save(user);
		System.out.println();

	}

}
