package com.example.trainingdietsapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trainingexercise", schema = "pracalicencjacka_training_db", catalog = "")
@IdClass(TrainingexerciseEntityPK.class)
public class TrainingexerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Exercise_id", nullable = false)
    private int exerciseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Training_id", nullable = false)
    private int trainingId;

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingexerciseEntity that = (TrainingexerciseEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (trainingId != that.trainingId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + trainingId;
        return result;
    }
}
