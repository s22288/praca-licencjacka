package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.dto.helperclasses.DietWithMeals;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.DietService.DietService;
import com.example.trainingapp.services.repositories.DietRepository;
import com.example.trainingapp.services.repositories.MealRepostiory;
import com.example.trainingapp.services.repositories.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/create-diet")
@CrossOrigin(origins = "*")
public class DietController {
    private static final Logger logger = LoggerFactory.getLogger(DietController.class);
    private DietService dietService;


    public DietController( DietService dietService) {
        this.dietService = dietService;

    }

    @GetMapping
    @RequestMapping("/all-mealTypes")
    public ResponseEntity<List<MealtypeEntity>> getAllMealTypes() {
        return ResponseEntity.ok(dietService.findAllTypeOfMeal());
    }


    @GetMapping
    @RequestMapping("/getMeals-byType")
    public ResponseEntity<List<MealWithAlternatives>> getMealsWithSpecificType(@RequestParam("typeid") int typeid) {

        return ResponseEntity.ok(dietService.findForuMealsBaseOnMealType(typeid));
    }

    @PostMapping()
    @RequestMapping("/save-diet")

    public ResponseEntity<String> saveDiet(@Valid @RequestBody DietEntity dietEntity) {
       dietEntity.setNormalUserId(1);



       dietService.saveDiet(dietEntity);

        return ResponseEntity.ok("Ok");
    }





}
