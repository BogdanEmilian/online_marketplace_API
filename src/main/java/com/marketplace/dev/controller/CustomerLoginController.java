package com.marketplace.dev.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.user.OAuth2User;

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

    @GetMapping("/useremail")
    public String useremail(@AuthenticationPrincipal OAuth2User user){
        return user.getAttribute("name");
    }
}
