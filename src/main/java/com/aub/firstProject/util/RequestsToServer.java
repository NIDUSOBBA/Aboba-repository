package com.aub.firstProject.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RequestsToServer {

    public static void saveImage(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://localhost:8080/image/upload";
        String putImage = "C:/Users/aub/Desktop/images/";
        File imageFile = new File(putImage + url);

        FileSystemResource fileResource = new FileSystemResource(imageFile);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Уникальный ID загруженного файла: " + response.getBody());
        } else {
            System.err.println("Ошибка загрузки файла. Статус: " + response.getStatusCode());
        }
    }

    public static void savePerson(Map<String, String> map) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String serverUrl = "http://localhost:8080/person/add";

        HttpEntity<Map<String, String>> requestSensor = new HttpEntity<>(map);
        var stringResponseEntity = template.postForEntity(serverUrl, requestSensor, String.class);
        if (stringResponseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("Пользователь успешно сохранен");
        }else {
            System.err.println("Ошибка загрузки Пользователя. Статус: " + stringResponseEntity.getStatusCode());
        }
    }
}
