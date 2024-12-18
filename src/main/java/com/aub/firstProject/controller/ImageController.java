package com.aub.firstProject.controller;

import com.aub.firstProject.util.ImageInit;
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
        return ImageInit.init(file);
    }
}
