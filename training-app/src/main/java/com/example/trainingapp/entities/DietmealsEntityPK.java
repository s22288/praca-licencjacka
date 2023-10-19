//package com.example.trainingapp.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import java.io.Serializable;
//
//public class DietmealsEntityPK implements Serializable {
//    @Column(name = "Diet_id", nullable = false)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int dietId;
//    @Column(name = "Meal_id", nullable = false)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int mealId;
//
//    public int getDietId() {
//        return dietId;
//    }
//
//    public void setDietId(int dietId) {
//        this.dietId = dietId;
//    }
//
//    public int getMealId() {
//        return mealId;
//    }
//
//    public void setMealId(int mealId) {
//        this.mealId = mealId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        DietmealsEntityPK that = (DietmealsEntityPK) o;
//
//        if (dietId != that.dietId) return false;
//        if (mealId != that.mealId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = dietId;
//        result = 31 * result + mealId;
//        return result;
//    }
//}
