package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "administrator", schema = "pracalicencjacka_training_db", catalog = "")


public class AdministratorEntity extends  NormaluserEntity {
    @Basic
    @Column(name = "canManageUser", nullable = false)
    private byte canManageUser;
    @Basic
    @Column(name = "canManageMeals", nullable = false)
    private byte canManageMeals;
    @Basic
    @Column(name = "canManageExercise", nullable = false)
    private byte canManageExercise;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "NormalUser_id", nullable = false)
//    private int normalUserId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministratorEntity that = (AdministratorEntity) o;

        if (canManageUser != that.canManageUser) return false;
        if (canManageMeals != that.canManageMeals) return false;
        if (canManageExercise != that.canManageExercise) return false;
//        if (normalUserId != that.normalUserId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) canManageUser;
        result = 31 * result + (int) canManageMeals;
        result = 31 * result + (int) canManageExercise;
//        result = 31 * result + normalUserId;
        return result;
    }
}
