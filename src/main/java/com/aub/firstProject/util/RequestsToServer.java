package com.aub.firstProject.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;

public class RequestsToServer {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();

    private static final String addingImage = "http://localhost:8080/image/upload";
    private static final String getImage = "C:/Users/aub/Desktop/images/";
    private static final String addingPerson = "http://localhost:8080/person/add";
    private static final String getPerson = "http://localhost:8080/person/get?id={id}";
    private static final String updateStatusPerson = "http://localhost:8080/person/update_status?email={email}&status={status}";
    private static final String getEveryoneWith = "http://localhost:8080/person/get_everyone_with?status={status}&update_status={update_status}";

    public static void saveImage(String url) {
        File imageFile = new File(getImage + url);

        FileSystemResource fileResource = new FileSystemResource(imageFile);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(addingImage, requestEntity, String.class);
        resultOfRequest(response,
                "Уникальный ID загруженного файла: " + response.getBody(),
                "Ошибка загрузки файла. Статус: " + response.getStatusCode()
        );
    }

    public static void savePerson(Map<String, String> map) {
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<Map<String, String>> requestSensor = new HttpEntity<>(map, headers);

        var response = restTemplate.postForEntity(addingPerson, requestSensor, String.class);

        resultOfRequest(response,
                "Пользователь успешно сохранен.",
                "Ошибка загрузки Пользователя. Статус: " + response.getStatusCode()
        );
    }

    public static void getPerson(Map<String, String> map) {
        var forEntity = restTemplate.getForEntity(getPerson, String.class, map);
        resultOfRequest(forEntity,
                "Успешно возвращен пользователь.",
                "Ошибка при возвращении пользователя."
        );
    }

    public static void updatePerson(Map<String, String> map) {

        var response = restTemplate.getForEntity(updateStatusPerson, String.class, map);
        resultOfRequest(response,
                "Успешное обновление статуса",
                "Что-то пошло не так при обновлении статуса");
    }

    public static void getEveryoneWith(Map<String, String> map) {
        map.putIfAbsent("status", null);
        map.putIfAbsent("update_status", null);
        var forEntity = restTemplate.getForEntity(getEveryoneWith, String.class, map);
        resultOfRequest(forEntity,
                "Успешно проведенная выборка.",
                "Что-то пошло не так при проведении выборки.");
    }

    public static void resultOfRequest(ResponseEntity<String> response, String trueMessage, String falseMessage) {
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(trueMessage);
        } else {
            System.err.println(falseMessage);
        }
    }
}
