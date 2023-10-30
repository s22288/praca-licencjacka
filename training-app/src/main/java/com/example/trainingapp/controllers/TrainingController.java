package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.PremiumUserSerivice;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import com.example.trainingapp.services.repositories.TrainingEventRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> saveDiet(@Valid @RequestBody TrainingEntity trainingEntity) {

        trainingEntity.setNormalUserId(1);



        trainingService.saveTraining(trainingEntity);

        return ResponseEntity.ok("Ok");
    }

    @PostMapping()
    @RequestMapping("/assign-todate")
    public  ResponseEntity <String> asignTrainingToDay( @Valid @RequestBody TrainingeventEntity ev){


        PremiumuserEntity premiumuserEntity = premiumUserSerivice.findById(1L);
       Set<PremiumuserEntity> premiumuserEntitySet = new HashSet<>();
       premiumuserEntitySet.add(premiumuserEntity);

        ev.setPremiumuserEntitySet(premiumuserEntitySet);
trainingService.saveTrainingEvent(ev);

        return ResponseEntity.ok("treninig");
    }


    @GetMapping
    @RequestMapping("/findMachine/{id}")
    public  ResponseEntity<TrainingmachineEntity> findMachineByid(@PathVariable long id){
        TrainingmachineEntity machineById = trainingService.findMachineById(id);
        return  ResponseEntity.ok(machineById);

    }

    @GetMapping
      @RequestMapping("/split-training")
    public  ResponseEntity<Map<String,List<ExerciseEntity>>> creteSplitTraining(){
        Map<String, List<ExerciseEntity>> splitTraining = trainingService.createSplitTraining();
        return  ResponseEntity.ok(splitTraining);

    }


}
