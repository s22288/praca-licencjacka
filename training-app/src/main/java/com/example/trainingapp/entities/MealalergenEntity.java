package com.example.trainingapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mealalergen", schema = "pracalicencjacka_training_db", catalog = "")
@IdClass(MealalergenEntityPK.class)
public class MealalergenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Meal_id", nullable = false)
    private int mealId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AlergicIngridients_id", nullable = false)
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

        MealalergenEntity that = (MealalergenEntity) o;

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
