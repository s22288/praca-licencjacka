package com.example.trainingapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MealalergenEntityPK implements Serializable {
    @Column(name = "Meal_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mealId;
    @Column(name = "AlergicIngridients_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alergicIngridientsId;

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getAlergicIngridientsId() {
        return alergicIngridientsId;
    }

    public void setAlergicIngridientsId(int alergicIngridientsId) {
        this.alergicIngridientsId = alergicIngridientsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealalergenEntityPK that = (MealalergenEntityPK) o;

        if (mealId != that.mealId) return false;
        if (alergicIngridientsId != that.alergicIngridientsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mealId;
        result = 31 * result + alergicIngridientsId;
        return result;
    }
}
