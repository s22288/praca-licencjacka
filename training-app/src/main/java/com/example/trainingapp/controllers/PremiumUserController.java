package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.dto.helperclasses.Indicator;
import com.example.trainingapp.services.functionality.UserService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        logger.info("email" + email);
        NormaluserEntity userFromDb = userService.findByEmail(email);
        Indicator indicators = userService.calculateIndicators(userFromDb.getId());


        return ResponseEntity.ok(indicators);

    }

    @GetMapping
    @RequestMapping("/check-user-status")

    public ResponseEntity<Indicator> checkIfUserIsPremium(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();

        NormaluserEntity userFromDb = userService.findByEmail(email);


        Indicator indicators = userService.calculateIndicators(userFromDb.getId());


        return ResponseEntity.ok(indicators);

    }
}
