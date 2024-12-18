package com.aub.firstProject.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageInit {
    private static final String UPLOAD_DIR = "C:/Users/aub/IdeaProjects/firstProject/uploads/";

    public static String init(MultipartFile file){
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
