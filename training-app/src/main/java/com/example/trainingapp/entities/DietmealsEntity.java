//package com.example.trainingapp.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "dietmeals", schema = "pracalicencjacka_training_db", catalog = "")
//@IdClass(DietmealsEntityPK.class)
//public class DietmealsEntity {
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "Diet_id", nullable = false)
//    private int dietId;
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "Meal_id", nullable = false)
//    private int mealId;
//
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
//        DietmealsEntity that = (DietmealsEntity) o;
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
