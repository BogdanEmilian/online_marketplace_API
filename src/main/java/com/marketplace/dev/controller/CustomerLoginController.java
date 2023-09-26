package com.marketplace.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerLoginController {

    @GetMapping("/")
    public String home(){
        return "Hello there!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "oke, doke";
    }
}
