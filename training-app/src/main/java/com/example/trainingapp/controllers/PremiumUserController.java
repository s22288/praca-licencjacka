package com.example.trainingapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/premium-user")
@CrossOrigin(origins = "*")
public class PremiumUserController {

    @GetMapping
    public ResponseEntity<String> Hello(){

        return ResponseEntity.ok("hello");

    }
}
