package com.aub.firstProject;


import com.aub.firstProject.util.ImageInit;
import com.aub.firstProject.util.PersonMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//		params.put("fullName","Test3");
//		params.put("age","63");
//		params.put("email","test3@test.com");
//		RequestsToServer.savePerson(params);

        //Запрос на вытаскивания пользователя
//		params.put("id","1");
//		RequestsToServer.getPerson(params);

        //Обновление статуса пользователя
//		params.put("email","test3@test.com");
//		params.put("status","offline");
//		RequestsToServer.updatePerson(params);

        //Запрос на выборку с status или update status один из параметров может отсутстваовать или оба
        //формат для задания даты 0000-00-00T00:00
//        params.put("status", "offline");
//        params.put("update_status", "2024-12-19T11:34");
//        RequestsToServer.getEveryoneWith(params);
    }

    @Bean
    public ImageInit imageInit() {
        return new ImageInit();
    }

    @Bean
    public PersonMapper personMapper() {
        return new PersonMapper();
    }

}
