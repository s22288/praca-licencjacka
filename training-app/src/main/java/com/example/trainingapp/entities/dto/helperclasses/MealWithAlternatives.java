package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.AlergicingridientsEntity;
import com.example.trainingapp.entities.MealEntity;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor

public class MealWithAlternatives {

    private MealEntity mealEntity;
    private List<MealEntity> alternatives;

    private List<AlergicingridientsEntity> allAlergics;

    public MealWithAlternatives(MealEntity mealEntity, List<MealEntity> alternatives, List<AlergicingridientsEntity> allAlergics) {
        this.mealEntity = mealEntity;
        this.alternatives = alternatives;
        this.allAlergics = allAlergics;
    }



    public MealEntity getMealEntity() {
        return mealEntity;
    }

    public void setMealEntity(MealEntity mealEntity) {
        this.mealEntity = mealEntity;
    }

    public List<MealEntity> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<MealEntity> alternatives) {
        this.alternatives = alternatives;
    }

    public List<AlergicingridientsEntity> getAllAlergics() {
        return allAlergics;
    }

    public void setAllAlergics(List<AlergicingridientsEntity> allAlergics) {
        this.allAlergics = allAlergics;
    }
}
