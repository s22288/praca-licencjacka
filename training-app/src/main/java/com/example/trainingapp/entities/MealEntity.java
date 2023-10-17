package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity
@Table(name = "meal", schema = "pracalicencjacka_training_db", catalog = "")
public class MealEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "mealName", nullable = false, length = 200)
    private String mealName;
    @Basic
    @Column(name = "photo", nullable = false, length = 200)
    private String photo;
    @Basic
    @Column(name = "calories", nullable = false)
    private int calories;
    @Basic
    @Column(name = "MealType_id", nullable = false)
    private int mealTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(int mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealEntity that = (MealEntity) o;

        if (id != that.id) return false;
        if (calories != that.calories) return false;
        if (mealTypeId != that.mealTypeId) return false;
        if (mealName != null ? !mealName.equals(that.mealName) : that.mealName != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mealName != null ? mealName.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + calories;
        result = 31 * result + mealTypeId;
        return result;
    }
}
