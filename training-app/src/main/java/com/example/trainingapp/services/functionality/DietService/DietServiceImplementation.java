package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.services.repositories.MealRepostiory;
import com.example.trainingapp.services.repositories.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DietServiceImplementation implements DietService {



    private MealRepostiory mealRepostiory;

    private MealTypeRepository mealTypeRepository;

    public DietServiceImplementation(MealRepostiory mealRepostiory, MealTypeRepository mealTypeRepository) {
        this.mealRepostiory = mealRepostiory;
        this.mealTypeRepository = mealTypeRepository;
    }

    @Override
    public Integer getDietBaseOnCaloriesAndDietType(int maxCalories) {
        int upper = maxCalories+100;
        int lowwer = maxCalories-100;
        AtomicInteger suma = new AtomicInteger();
        mealRepostiory.findAll().forEach(
                mealEntity -> {
                    int mealCalories = mealEntity.getCalories();
                    if ((lowwer > suma.get()) && (suma.get()< upper)) {
                        suma.addAndGet(mealCalories);


                    }
                }
        );

        return suma.get();
    }

    @Override
    public List<MealEntity> findForuMealsBaseOnMealType(int typeId) {
     return    mealRepostiory.findFourMealsBaseOnType(typeId);

    }

    @Override
    public List<MealtypeEntity> findAllTypeOfMeal() {
        return mealTypeRepository.findAll();
    }
}
