package com.aub.firstProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {

    @GetMapping("/")
    public String home() {
        return "Hello world!";
    }

}

/*

 */

