package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.repositories.MealRepostiory;
import com.example.trainingapp.services.repositories.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class DietServiceImplementation implements DietService {



    private MealRepostiory mealRepostiory;

    private MealTypeRepository mealTypeRepository;

    private  List<MealEntity> used = new ArrayList<>();


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
    public List<MealWithAlternatives> findForuMealsBaseOnMealType(int typeId) {
        List<MealWithAlternatives> mealAndAlternatives = new ArrayList<>();
        List<MealEntity> findFourMeals = mealRepostiory.findAll().stream().filter(m -> m.getMealTypeId()==typeId).limit(4).toList();
        used.addAll(findFourMeals);
        findFourMeals.forEach(t ->{
            MealWithAlternatives alternatives = new MealWithAlternatives();
            alternatives.setMealEntity(t);
            List<MealEntity> different =  findDifferent(used,t.getMealTypeId());
            alternatives.setAlternatives(different);
            mealAndAlternatives.add(alternatives);
        });
        return mealAndAlternatives;

    }


    public List<MealEntity> findDifferent(List<MealEntity> base, int mealType) {
        List<MealEntity> differentTwo = mealRepostiory.findAll();
        differentTwo.removeAll(base);
        List<MealEntity> limited = differentTwo.stream().filter(t -> t.getMealTypeId()==mealType).limit(2).collect(Collectors.toList());
        if(limited.size()==2) {
            used.add(limited.get(0));
            used.add(limited.get(1));
        }

        return limited;
    }

    @Override
    public List<MealtypeEntity> findAllTypeOfMeal() {
        return mealTypeRepository.findAll();
    }
}
