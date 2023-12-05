package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.MealEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString

@Builder
public class ExerciseWithAlternatives {
    private ExerciseEntity exerciseEntity;
    private List<ExerciseEntity> alternatives;

    public ExerciseWithAlternatives() {
    }

    public ExerciseWithAlternatives(ExerciseEntity exerciseEntity, List<ExerciseEntity> alternatives) {
        this.exerciseEntity = exerciseEntity;
        this.alternatives = alternatives;
    }

    public ExerciseEntity getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseEntity exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public List<ExerciseEntity> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<ExerciseEntity> alternatives) {
        this.alternatives = alternatives;
    }
}
