package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.PremiumUserSerivice;
import com.example.trainingapp.services.functionality.UserService.UserService;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import com.example.trainingapp.services.repositories.TrainingEventRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/create-training")
@CrossOrigin(origins = "*")
public class TrainingController {
    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class);
private PremiumUserSerivice premiumUserSerivice;


    private TrainingService trainingService;


    private UserService userService;

    public TrainingController(PremiumUserSerivice premiumUserSerivice, TrainingService trainingService, UserService userService) {
        this.premiumUserSerivice = premiumUserSerivice;
        this.trainingService = trainingService;
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/exercise-for-bodyparts")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER', 'USER')")

    public ResponseEntity<List<ExerciseWithAlternatives>> getExercisesForTrainingType() {
        List<ExerciseWithAlternatives> exerciseWithAlternativesForEachBodyPart = trainingService.findExerciseWithAlternativesForEachBodyPart();
        return ResponseEntity.ok(exerciseWithAlternativesForEachBodyPart);
    }

    @PostMapping()
    @RequestMapping("/save-training")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER', 'USER')")

    public ResponseEntity<String> saveDiet(@Valid @RequestBody TrainingEntity trainingEntity) {
        logger.info("treniing zapisany" + trainingEntity);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =     authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity userFromDb = userService.findByEmail(email);
        trainingEntity.setNormalUserId(userFromDb.getId());



        trainingService.saveTraining(trainingEntity);

        return ResponseEntity.ok("Ok");
    }

    @PostMapping()
    @RequestMapping("/assign-todate")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER')")

    public  ResponseEntity <String> asignTrainingToDay( @Valid @RequestBody TrainingeventEntity ev){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((PremiumuserEntity) principal).getEmail();


        PremiumuserEntity premiumuserEntity = premiumUserSerivice.findByEmail(email);
       Set<PremiumuserEntity> premiumuserEntitySet = new HashSet<>();
       premiumuserEntitySet.add(premiumuserEntity);

        ev.setPremiumuserEntitySet(premiumuserEntitySet);
trainingService.saveTrainingEvent(ev);

        return ResponseEntity.ok("treninig");
    }


    @GetMapping
    @RequestMapping("/findMachine/{id}")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER', 'USER')")

    public  ResponseEntity<TrainingmachineEntity> findMachineByid(@PathVariable long id){
        TrainingmachineEntity machineById = trainingService.findMachineById(id);
        return  ResponseEntity.ok(machineById);

    }

    @GetMapping
      @RequestMapping("/split-training")
    @PreAuthorize("hasAnyAuthority('PREMIUMUSER', 'USER')")

    public  ResponseEntity<Map<String,List<ExerciseWithAlternatives>>> creteSplitTraining(){
        Map<String,List<ExerciseWithAlternatives>> splitTraining = trainingService.createSplitTraining();
        return  ResponseEntity.ok(splitTraining);

    }




}
