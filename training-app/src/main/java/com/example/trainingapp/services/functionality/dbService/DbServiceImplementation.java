package com.example.trainingapp.services.functionality.dbService;

import com.example.trainingapp.services.repositories.ExerciseRepository;
import com.example.trainingapp.services.repositories.MealRepostiory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbServiceImplementation implements DbService {
    @Autowired
    private MealRepostiory mealRepostiory;




    @Autowired
    private ExerciseRepository exerciseRepository;
@PostConstruct
    public  void initDB (){
    mealRepostiory.InsertMeals(2000);
    exerciseRepository.insertExercises(2000);
    }





}
