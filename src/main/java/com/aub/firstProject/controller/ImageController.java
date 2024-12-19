package com.aub.firstProject.controller;

import com.aub.firstProject.util.ImageInit;
import com.aub.firstProject.util.Timer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        Timer.timerFiveSeconds();
        return ImageInit.init(file);
    }
}
