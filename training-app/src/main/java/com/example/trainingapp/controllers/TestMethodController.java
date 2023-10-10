package com.example.trainingapp.controllers;

import com.example.trainingapp.services.functionality.UserService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*")

public class TestMethodController {
    private UserService userService;

    public TestMethodController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> Hello(){

        return ResponseEntity.ok("hello");

    }
    @GetMapping
    @RequestMapping("/age")
    public ResponseEntity<Integer> getUsersAge(@RequestParam("id") int id){
        int ageOfUser = userService.calculateAge(id);
        return ResponseEntity.ok(ageOfUser);

    }
}
