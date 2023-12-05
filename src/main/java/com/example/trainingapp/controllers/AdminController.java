package com.example.trainingapp.controllers;

import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.services.functionality.DietService.DietService;
import com.example.trainingapp.services.functionality.TrainingService.TrainingService;
import com.example.trainingapp.services.functionality.UserService.UserService;
import com.example.trainingapp.services.repositories.DietRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin-user")
@CrossOrigin(origins = "*")
public class AdminController {

    private UserService userService;

    private DietService dietService;
    private TrainingService trainingService;

    public AdminController(UserService userService, DietService dietService, TrainingService trainingService) {
        this.userService = userService;
        this.dietService = dietService;
        this.trainingService = trainingService;
    }

    @GetMapping
    @RequestMapping("/get-users")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public ResponseEntity<List<NormaluserEntity>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PostMapping
    @RequestMapping("/delete-user/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<String> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return  ResponseEntity.ok("deleted");

    }
    @GetMapping
    @RequestMapping("/get-exercises")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<List<ExerciseEntity>> getExercises(Pageable pageable){

        return  ResponseEntity.ok(trainingService.getAllExerciesPageable(pageable));

    }

    @PostMapping
    @RequestMapping("/delete-exercise/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<String> deleteExerciseById(@PathVariable long id){
        trainingService.deleteExerciseByid(id);
        return  ResponseEntity.ok("deleted");

    }
    @GetMapping
    @RequestMapping("/get-meals")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<List<MealEntity>> getMeals(Pageable pageable){
        List<MealEntity> allPageable = dietService.getAllPageable(pageable);
        return  ResponseEntity.ok(allPageable);

    }


    @PostMapping
    @RequestMapping("/add-exercise")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<String> addExercise(@Valid @RequestBody ExerciseEntity exerciseEntity){
        trainingService.saveExercise(exerciseEntity);
        return  ResponseEntity.ok("200");

    }

    @PostMapping
    @RequestMapping("/add-meal")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<String> addMeal( @Valid @RequestBody MealEntity mealEntity){
        dietService.saveMeal(mealEntity);

        return  ResponseEntity.ok("200");

    }

    @PostMapping
    @RequestMapping("/delete-meal/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public  ResponseEntity<String> deleteMealById(@PathVariable long id){
        dietService.deleteMealByid(id);
        return  ResponseEntity.ok("deleted");

    }


}
