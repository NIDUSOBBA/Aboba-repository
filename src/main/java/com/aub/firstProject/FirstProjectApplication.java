package com.aub.firstProject;


import com.aub.firstProject.util.RequestsToServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
        Map<String, String> params = new HashMap<>();
        //Изображения барть из папки image путь указывать из папки "Скрины/киберпанк/Man.png"
//		RequestsToServer.saveImage();
        //Запрос на добавление пользователя
//		params.put("image","C:/Users/aub/IdeaProjects/firstProject/uploads/349f5785-f80c-46aa-a8ca-16002e502030_Man.png");
//		params.put("fullName","Test1");
//		params.put("age","12");
//		params.put("email","test1@test.com");
//		RequestsToServer.savePerson(params);
        //Запрос на вытаскивания пользователя
//		params.put("id","1");
//		RequestsToServer.getPerson(params);
        //Обновление статуса пользователя
		params.put("email","test1@test.com");
		params.put("status","offline");
		RequestsToServer.updatePerson(params);


    }

}
