package com.example.trainingapp.controllers;

import com.example.trainingapp.controllers.auth.AuthenticationResponse;
import com.example.trainingapp.controllers.auth.AuthenticationService;
import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.dto.helperclasses.DietWithMeals;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.functionality.DietService.DietService;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.UserService;
import com.example.trainingapp.services.repositories.DietRepository;
import com.example.trainingapp.services.repositories.MaxInExerciseRepository;
import com.example.trainingapp.services.repositories.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/normal-user")
@CrossOrigin("*")
@EnableMethodSecurity
(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class NormalUserController  {
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);
    private UserService userService;

    private  AuthenticationService service;



    private DietService dietService;



    private TrainingService trainingService;

    public NormalUserController(UserService userService, AuthenticationService service, DietService dietService, TrainingService trainingService) {
        this.userService = userService;
        this.service = service;
        this.dietService = dietService;
        this.trainingService = trainingService;
    }

    @GetMapping
    @RequestMapping("/cpm")
    public ResponseEntity<Double> getCpmOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);

        return ResponseEntity.ok(userFromDb.calculateCPM());
    }


    @PostMapping


    @RequestMapping("/update-data")
    public ResponseEntity<String> updateUserMesurements(@Valid @RequestBody NormaluserEntity userData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);

        if (userFromDb != null) {
            userFromDb.setWeight(userData.getWeight());
            userFromDb.setHeight(userData.getHeight());
            userFromDb.setBirthDate(userData.getBirthDate());
            userFromDb.setPalfactor(userData.getPalfactor());

            userService.saveUser(userFromDb);
            return ResponseEntity.ok("userUpdated");
        }
        return ResponseEntity.ok("not found");


    }


    @PostMapping
    @RequestMapping("/account-data")
    @PreAuthorize("hasAnyAuthority('USER')")

    public ResponseEntity<NormaluserEntity> updateUserMesurements() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);

//        NormaluserEntity userFromDb = userService.findUserByid(1l);


        return ResponseEntity.ok(userFromDb);


    }

    // users-maxes

    @GetMapping
    @RequestMapping("/user-maxes")
    public ResponseEntity<List<MaxinexerciseEntity>> getUsersMaxes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();

        NormaluserEntity userFromDb = userService.findByEmail(email);
        logger.info("id" + userFromDb.getId());
        List<MaxinexerciseEntity> usersMaxes = userService.getUsersMaxes(userFromDb.getId());
        return ResponseEntity.ok(usersMaxes);

    }

    @PostMapping

    @RequestMapping("/add-maxes")
    public ResponseEntity<String> addUserMax( @RequestBody MaxinexerciseEntity maxinexerciseEntity ) {

        logger.info("add max" + maxinexerciseEntity);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        logger.info("id" + userFromDb.getEmail() + " email " + email);

        maxinexerciseEntity.setNormalUserId(userFromDb.getId());
        trainingService.saveMaxInExercise(maxinexerciseEntity);

        return ResponseEntity.ok("Updated ok 200");

    }
    @CrossOrigin
    @RequestMapping("/diets")
    public ResponseEntity<List<DietWithMeals>> getUserDiets() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        List<DietWithMeals> userDiets = dietService.findDietsByUserIdWithMeals(userFromDb.getId());


        return ResponseEntity.ok().body(userDiets);
    }
    @CrossOrigin

    @GetMapping
    @RequestMapping("/delete-diet/{id}")
    public  ResponseEntity<String> deleteDiet(@PathVariable long id){
        dietService.deleteDietById( id);
        return  ResponseEntity.ok("deleted");

    }

    @GetMapping
    @RequestMapping("/delete-training/{id}")
    public  ResponseEntity<String> deleteTraining(@PathVariable long id){
        trainingService.deleteTrainingById( id);
        return  ResponseEntity.ok("deleted");

    }

    @CrossOrigin
    @RequestMapping("/user-trainings")
    public ResponseEntity<List<TrainingEntity>> getUserTrainings() {
        logger.info("trainings" + "treniing");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        List<TrainingEntity> allUserTraining = trainingService.getAllUserTraining(userFromDb.getId());

        return ResponseEntity.ok().body(allUserTraining);
    }

    @CrossOrigin
    @GetMapping

    @RequestMapping("/trainings-days")
    public ResponseEntity<List<TrainingWithDay>> getUserTrainingsWithDays() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        List<TrainingWithDay> trainigsWithDays = trainingService.getTrainigsWithDays(userFromDb.getId());


        return ResponseEntity.ok().body(trainigsWithDays);
    }

    @PostMapping("/update-premium")
    public ResponseEntity<AuthenticationResponse> updateToPremium(){

        return ResponseEntity.ok(service.updateToPremium());

    }

}
