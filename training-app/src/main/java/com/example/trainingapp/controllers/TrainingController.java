package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.PremiumUserSerivice;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import com.example.trainingapp.services.repositories.TrainingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/create-training")
@CrossOrigin(origins = "*")
public class TrainingController {
    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class);
private PremiumUserSerivice premiumUserSerivice;


    private TrainingService trainingService;


    public TrainingController(PremiumUserSerivice premiumUserSerivice, TrainingService trainingService) {
        this.premiumUserSerivice = premiumUserSerivice;
        this.trainingService = trainingService;
    }

    @GetMapping
    @RequestMapping("/exercise-for-bodyparts")
    public ResponseEntity<List<ExerciseWithAlternatives>> getExercisesForTrainingType() {
        List<ExerciseWithAlternatives> exerciseWithAlternativesForEachBodyPart = trainingService.findExerciseWithAlternativesForEachBodyPart();
        return ResponseEntity.ok(exerciseWithAlternativesForEachBodyPart);
    }

    @PostMapping()
    @RequestMapping("/save-training")

    public ResponseEntity<String> saveDiet(@RequestBody TrainingEntity trainingEntity) {
        logger.info("training" +trainingEntity.getExerciseEntitySet());
        trainingEntity.setNormalUserId(1);



        trainingService.saveTraining(trainingEntity);

        return ResponseEntity.ok("Ok");
    }

    @PostMapping()
    @RequestMapping("/assign-todate")
    public  ResponseEntity <String> asignTrainingToDay(@RequestBody TrainingeventEntity ev, @RequestParam("idTraining") int idTraining){
        logger.info("Training: " + ev);
        logger.info("idTraining: " + idTraining);

        PremiumuserEntity premiumuserEntity = premiumUserSerivice.findById(1L);
       Set<PremiumuserEntity> premiumuserEntitySet = new HashSet<>();
       premiumuserEntitySet.add(premiumuserEntity);

        ev.setPremiumuserEntitySet(premiumuserEntitySet);
trainingService.saveTrainingEvent(ev);

        return ResponseEntity.ok("treninig");
    }

}
