package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/create-training")
@CrossOrigin(origins = "*")
public class TrainingController {
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }


    @GetMapping
    @RequestMapping("/getTrainings-byType")
    public ResponseEntity<String> getExercisesForTrainingType(@RequestParam("typeid") int typeid) {

        return ResponseEntity.ok("ok");
    }

}
