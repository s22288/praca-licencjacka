package com.example.trainingapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exercisebodypart", schema = "pracalicencjacka_training_db", catalog = "")
@IdClass(ExercisebodypartEntityPK.class)
public class ExercisebodypartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Exercise_id", nullable = false)
    private int exerciseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BodyPart_id", nullable = false)
    private int bodyPartId;

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getBodyPartId() {
        return bodyPartId;
    }

    public void setBodyPartId(int bodyPartId) {
        this.bodyPartId = bodyPartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExercisebodypartEntity that = (ExercisebodypartEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (bodyPartId != that.bodyPartId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + bodyPartId;
        return result;
    }
}
