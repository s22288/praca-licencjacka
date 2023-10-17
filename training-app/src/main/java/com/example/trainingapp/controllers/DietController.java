package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.DietService.DietService;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/create-diet")
@CrossOrigin(origins = "*")
public class DietController {
    private static final Logger logger = LoggerFactory.getLogger(DietController.class);


    private DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping
    @RequestMapping("/all-mealTypes")
    public ResponseEntity<List<MealtypeEntity>> getAllMealTypes(){
    return  ResponseEntity.ok(    dietService.findAllTypeOfMeal());
    }


    @GetMapping
    @RequestMapping("/getMeals-byType")
    public ResponseEntity<List<MealWithAlternatives>> getMealsWithSpecificType(@RequestParam("typeid") int typeid){

        logger.info("dania " +  dietService.findForuMealsBaseOnMealType(typeid));
        return  ResponseEntity.ok(    dietService.findForuMealsBaseOnMealType(typeid));
    }

    @PostMapping
    @RequestMapping("/save-diet")
    public ResponseEntity<String> saveDietToDb(@RequestBody DietEntity diet) {
        logger.info("diet-saved" + diet);

        return ResponseEntity.ok("saved");
    }


}
