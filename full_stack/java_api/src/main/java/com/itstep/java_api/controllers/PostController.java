package com.itstep.java_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/java/api/post")
    public String test()
    {
        return "Hello Java Api";
    }

}
