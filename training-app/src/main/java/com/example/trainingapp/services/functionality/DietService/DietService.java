package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DietService {
     Integer getDietBaseOnCaloriesAndDietType(int calories);
     List<MealEntity> findForuMealsBaseOnMealType(int typeid);

     List<MealtypeEntity> findAllTypeOfMeal();
}
