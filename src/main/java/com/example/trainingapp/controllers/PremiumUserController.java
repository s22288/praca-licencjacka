package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.PremiumuserEntity;
import com.example.trainingapp.entities.dto.helperclasses.Indicator;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.PremiumUserSerivice;
import com.example.trainingapp.services.functionality.UserService.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/premium-user")
@CrossOrigin(origins = "*")
public class PremiumUserController {
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);
private TrainingService trainingService;
    private UserService userService;

    private PremiumUserSerivice premiumUserSerivice;

    public PremiumUserController(TrainingService trainingService, UserService userService, PremiumUserSerivice premiumUserSerivice) {
        this.trainingService = trainingService;
        this.userService = userService;
        this.premiumUserSerivice = premiumUserSerivice;
    }
    @GetMapping

    @RequestMapping("/trainings-days")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER')")

    public ResponseEntity<List<TrainingWithDay>> getUserTrainingsWithDays() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        List<TrainingWithDay> trainigsWithDays = trainingService.getTrainigsWithDays(userFromDb.getId());


        return ResponseEntity.ok().body(trainigsWithDays);
    }
    @GetMapping
    @RequestMapping("/indicators")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER')")

    public ResponseEntity<Indicator> CalculateIndicators() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        logger.info("email" + email);
        NormaluserEntity userFromDb = userService.findByEmail(email);
        Indicator indicators = userService.calculateIndicators(userFromDb.getId());


        return ResponseEntity.ok(indicators);

    }

    @GetMapping
    @RequestMapping("/check-user-status")

    public ResponseEntity<Indicator> checkIfUserIsPremium() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();

        NormaluserEntity userFromDb = userService.findByEmail(email);


        Indicator indicators = userService.calculateIndicators(userFromDb.getId());


        return ResponseEntity.ok(indicators);

    }



    @PostMapping
    @RequestMapping("/account-data")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER')")

    public ResponseEntity<NormaluserEntity> updateUserMesurements() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((PremiumuserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        return ResponseEntity.ok(userFromDb);
    }

    @PostMapping

    @PreAuthorize("hasAnyAuthority('PREMIUMUSER')")

    @RequestMapping("/update-data")
    public ResponseEntity<String> updateUserMesurements(@Valid @RequestBody PremiumuserEntity userData) {
        System.out.println(userData);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((PremiumuserEntity) principal).getEmail();
        PremiumuserEntity userFromDb =  premiumUserSerivice.findByEmail(email);

        if (userFromDb != null) {
            userFromDb.setWeight(userData.getWeight());
            userFromDb.setHeight(userData.getHeight());
            userFromDb.setBirthDate(userData.getBirthDate());
            userFromDb.setPalfactor(userData.getPalfactor());
            userFromDb.setHipsCircumference(userData.getHipsCircumference());
            userFromDb.setWaistCircumference(userData.getWaistCircumference());
            userFromDb.setStartSubscription(userData.getStartSubscription());
            userFromDb.setEndSubscription(userData.getEndSubscription());

            userService.saveUser(userFromDb);
            return ResponseEntity.ok("userUpdated");
        }
        return ResponseEntity.ok("not found");


    }
}
