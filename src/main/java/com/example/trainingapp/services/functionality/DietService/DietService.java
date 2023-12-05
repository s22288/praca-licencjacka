package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.AlergicingridientsEntity;
import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.DietWithMeals;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DietService {
     List<MealEntity> getDietBaseOnCaloriesAndDietType(int calories);
     List<MealWithAlternatives> findForuMealsBaseOnMealType(int typeid,int calories);

     List<MealtypeEntity> findAllTypeOfMeal();

     List<DietWithMeals> findDietsByUserIdWithMeals (int userId);

     void saveDiet(DietEntity dietEntity);
     void deleteDietById(long id);

     List<AlergicingridientsEntity> findAllAlergens(List<MealEntity> mealEntityList);

     List<MealEntity> getAllMeals();
List<MealEntity> getAllPageable(Pageable pageable);
     void deleteMealByid(long id);
     void saveMeal(MealEntity mealEntity);

}
