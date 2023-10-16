package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.services.functionality.DietService.DietService;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public ResponseEntity<List<MealEntity>> getMealsWithSpecificType(@RequestParam("typeid") int typeid){
        return  ResponseEntity.ok(    dietService.findForuMealsBaseOnMealType(typeid));
    }


}
