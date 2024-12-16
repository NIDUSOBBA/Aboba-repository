package com.aub.firstProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {

    private static final String UPLOAD_DIR = "C:/Users/aub/IdeaProjects/firstProject/uploads/";

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        String uniqueId = UUID.randomUUID().toString();
        String fileName = uniqueId + "_" + file.getOriginalFilename();
        File saveFile = new File(UPLOAD_DIR, fileName);

        try {
            saveFile.getParentFile().mkdirs();
            file.transferTo(saveFile);
            return uniqueId;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
}
