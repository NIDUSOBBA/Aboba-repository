package com.aub.firstProject.controller;

import com.aub.firstProject.util.ImageInit;
import com.aub.firstProject.util.Waiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageInit imageInit;

    @Autowired
    public ImageController(ImageInit imageInit) {
        this.imageInit = imageInit;
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        Waiting.waitFiveSeconds();
        // зачем тут через статичный метод? переделать на использование сервиса, спрингового компонента
        return imageInit.init(file);
    }
}
