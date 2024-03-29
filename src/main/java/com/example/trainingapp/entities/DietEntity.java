package com.example.trainingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@Entity
@Setter
@Table(name = "diet", schema = "pracalicencjacka_training_db", catalog = "")
public class DietEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "CaloriesCount", nullable = false)
    @Max( 15000)
    private int caloriesCount;
    @Basic
    @Column(name = "dietName", nullable = false, length = 200)
    @Size(min = 1, message = "{validation.dietName.size.too_short}")
    @Size(max = 200, message = "{validation.dietName.size.too_long}")
    private String dietName;
    @Basic
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;
    @Basic
    @Column(name = "dietGoal",  nullable = false,length = 200)
    private String dietGoal;

    @ManyToMany
    @JoinTable(name = "dietmeals",joinColumns = @JoinColumn( name ="dietId" ),inverseJoinColumns = @JoinColumn(name = "mealId"))
    private Set<MealEntity> mealEntitySet = new HashSet<>();



    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCaloriesCount(int caloriesCount) {
        this.caloriesCount = caloriesCount;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public void setDietGoal(String dietGoal) {
        this.dietGoal = dietGoal;
    }

    public int getCaloriesCount() {
        return caloriesCount;
    }

    public String getDietName() {
        return dietName;
    }

    public int getNormalUserId() {
        return normalUserId;
    }

    public String getDietGoal() {
        return dietGoal;
    }

    public Set<MealEntity> getMealEntitySet() {
        return mealEntitySet;
    }

    public int getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DietEntity that = (DietEntity) o;

        if (id != that.id) return false;
        if (caloriesCount != that.caloriesCount) return false;
        if (normalUserId != that.normalUserId) return false;
        if (dietName != null ? !dietName.equals(that.dietName) : that.dietName != null) return false;
        if (dietGoal != null ? !dietGoal.equals(that.dietGoal) : that.dietGoal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + caloriesCount;
        result = 31 * result + (dietName != null ? dietName.hashCode() : 0);
        result = 31 * result + normalUserId;
        result = 31 * result + (dietGoal != null ? dietGoal.hashCode() : 0);
        return result;
    }
}
