package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/create-training")
@CrossOrigin(origins = "*")
public class TrainingController {
    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class);

    private TrainingService trainingService;


    public TrainingController(TrainingService trainingService) {
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
}
