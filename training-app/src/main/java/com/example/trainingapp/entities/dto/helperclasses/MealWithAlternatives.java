package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.MealEntity;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealWithAlternatives {

    private MealEntity mealEntity;
    private List<MealEntity> alternatives;
}
