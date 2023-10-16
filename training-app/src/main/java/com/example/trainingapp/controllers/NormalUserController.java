package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.services.functionality.UserService.UserService;
import com.example.trainingapp.services.repositories.MaxInExerciseRepository;
import com.example.trainingapp.services.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/normal-user")
@CrossOrigin(origins = "*")

public class NormalUserController {
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);
    private UserService userService;

    private UserRepository userRepository;

    private MaxInExerciseRepository maxInExerciseRepository;

    public NormalUserController(UserService userService, UserRepository userRepository,MaxInExerciseRepository maxInExerciseRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.maxInExerciseRepository = maxInExerciseRepository;
    }


    @GetMapping
    @RequestMapping("/age")
    public ResponseEntity<Integer> getUsersAge(@RequestParam("id") int id) {
        int ageOfUser = userService.calculateAge(id);
        return ResponseEntity.ok(ageOfUser);

    }

    @GetMapping
    @RequestMapping("/cpm")
    public ResponseEntity<Double> getCpmOfUser() {
        NormaluserEntity normaluserEntity = userRepository.findById(1L).get();
        logger.info("user data" + normaluserEntity);
        logger.info("age " + normaluserEntity.calculateAgeFromBirthDate());
        return ResponseEntity.ok(normaluserEntity.calculateCPM());
    }


    @PostMapping
    @RequestMapping("/update-data")
    public ResponseEntity<String> updateUserMesurements(@RequestBody NormaluserEntity userData) {
        logger.info("updated user data " + userData);
        NormaluserEntity userFromDb = userRepository.findById(1L).orElse(null);
        if (userFromDb != null) {
            userFromDb.setWeight(userData.getWeight());
            userFromDb.setHeight(userData.getHeight());
            userFromDb.setBirthDate(userData.getBirthDate());
            userFromDb.setPalfactor(userData.getPalfactor());

            userRepository.save(userFromDb);
            return ResponseEntity.ok("userUpdated");
        }
        return ResponseEntity.ok("not found");


    }


    @PostMapping
    @RequestMapping("/account-data")
    public ResponseEntity<NormaluserEntity> updateUserMesurements() {
        NormaluserEntity userFromDb = userRepository.findById(1L).orElse(null);

        return ResponseEntity.ok(userFromDb);


    }

    // users-maxes

    @GetMapping
    @RequestMapping("/user-maxes")
    public ResponseEntity<List<MaxinexerciseEntity>> getUsersAge() {
//        NormaluserEntity userFromDb = userRepository.findById(1L).orElse(null);
        List<MaxinexerciseEntity> usersMaxes = userService.getUsersMaxes(1);
        return ResponseEntity.ok(usersMaxes);

    }


    @PostMapping
    @RequestMapping("/add-maxes")
    public ResponseEntity<String> AddUserMax( @RequestBody MaxinexerciseEntity maxinexerciseEntity) {

        maxinexerciseEntity.setNormalUserId(1);
        maxInExerciseRepository.save(maxinexerciseEntity);

        return ResponseEntity.ok("Updated ok 200");

    }

}
