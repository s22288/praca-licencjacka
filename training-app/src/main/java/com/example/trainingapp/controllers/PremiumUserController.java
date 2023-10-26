package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.dto.helperclasses.Indicator;
import com.example.trainingapp.services.functionality.UserService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/premium-user")
@CrossOrigin(origins = "*")
public class PremiumUserController {
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);

    private UserService userService;

    public PremiumUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/indicators")

    public ResponseEntity<Indicator> CalculateIndicators(){
        Indicator indicators = userService.calculateIndicators(1);


        return ResponseEntity.ok(indicators);

    }
}
