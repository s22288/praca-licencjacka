package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.services.functionality.UserService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@CrossOrigin(origins = "*")

public class DemoController {
    private UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello for secure");
    }


}
