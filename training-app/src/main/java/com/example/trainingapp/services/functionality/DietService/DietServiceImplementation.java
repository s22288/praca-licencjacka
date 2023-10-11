package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.services.repositories.MealRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DietServiceImplementation implements DietService {


    @Autowired
    private MealRepostiory mealRepostiory;

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
}
