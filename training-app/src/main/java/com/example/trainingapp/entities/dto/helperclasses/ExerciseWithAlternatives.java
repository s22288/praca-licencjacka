package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.MealEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseWithAlternatives {
    private ExerciseEntity exerciseEntity;
    private List<ExerciseEntity> alternatives;

}
