package com.example.trainingapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;


import java.util.HashSet;
import java.util.Set;


@Entity
//@Getter
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
    @Column(name = "photo", nullable = false)
    private String photo;
    @Basic
    @Column(name = "calories", nullable = false)
    @Min(value = 1, message = "{validation.calories.size.too_low}")
    @Max(value = 15000, message = "{validation.calories.size.too_big}")

    private int calories;
    @Basic
    @Column(name = "MealType_id", nullable = false)
    private int mealTypeId;
    @ManyToMany
    @JoinTable(name = "mealalergen",joinColumns = @JoinColumn( name ="mealId" ),inverseJoinColumns = @JoinColumn(name = "alergicingridientsId"))
    private Set<AlergicingridientsEntity> alergicingridientsEntitySet = new HashSet<>();


    @ManyToMany
    @JoinTable (name = "dietmeals",joinColumns =@JoinColumn(name ="mealId" ),inverseJoinColumns = @JoinColumn(name = "dietId"))
    private Set<DietEntity> dietEntitySet = new HashSet<>();
    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore

    public Set<DietEntity> getDietEntitySet() {
        return dietEntitySet;
    }

    public Set<AlergicingridientsEntity> getAlergicingridientsEntitySet() {
        return alergicingridientsEntitySet;
    }

    public void setAlergicingridientsEntitySet(Set<AlergicingridientsEntity> alergicingridientsEntitySet) {
        this.alergicingridientsEntitySet = alergicingridientsEntitySet;
    }

    public void setDietEntitySet(Set<DietEntity> dietEntitySet) {
        this.dietEntitySet = dietEntitySet;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setMealTypeId(int mealTypeId) {
        this.mealTypeId = mealTypeId;
    }
    public void addDiet(DietEntity dietEntity){
        this.dietEntitySet.add(dietEntity);
dietEntity.getMealEntitySet().add(this);
    }

//    public void remove(MealEntity mealEntity){
//        this.mealEntitySet.remove(mealEntity);
//        mealEntity.getDietEntitySet().remove(this);
//
//    }






    public int getCalories() {
        return calories;
    }

    public int getId() {
        return id;
    }

    public String getMealName() {
        return mealName;
    }

    public String getPhoto() {
        return photo;
    }

    public int getMealTypeId() {
        return mealTypeId;
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

    @Override
    public String toString() {
        return "MealEntity{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", photo='" + photo + '\'' +
                ", calories=" + calories +
                ", mealTypeId=" + mealTypeId +
                '}';
    }
}
