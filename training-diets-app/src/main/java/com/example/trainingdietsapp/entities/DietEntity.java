package com.example.trainingdietsapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diet", schema = "pracalicencjacka_training_db", catalog = "")
public class DietEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "CaloriesCount", nullable = false)
    private int caloriesCount;
    @Basic
    @Column(name = "dietName", nullable = false, length = 200)
    private String dietName;
    @Basic
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;
    @Basic
    @Column(name = "dietGoal", nullable = false, length = 200)
    private String dietGoal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaloriesCount() {
        return caloriesCount;
    }

    public void setCaloriesCount(int caloriesCount) {
        this.caloriesCount = caloriesCount;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public int getNormalUserId() {
        return normalUserId;
    }

    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }

    public String getDietGoal() {
        return dietGoal;
    }

    public void setDietGoal(String dietGoal) {
        this.dietGoal = dietGoal;
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
