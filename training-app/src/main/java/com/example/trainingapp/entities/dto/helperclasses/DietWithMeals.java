package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DietWithMeals {
   private  DietEntity dietEntity;
   private List<MealEntity> dietMeals;
}
