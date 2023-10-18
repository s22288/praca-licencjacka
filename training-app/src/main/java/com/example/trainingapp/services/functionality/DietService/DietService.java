package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DietService {
     Integer getDietBaseOnCaloriesAndDietType(int calories);
     List<MealWithAlternatives> findForuMealsBaseOnMealType(int typeid);

     List<MealtypeEntity> findAllTypeOfMeal();

     List<DietEntity> findDietsByUserIdWithMeals (int userId);
}
