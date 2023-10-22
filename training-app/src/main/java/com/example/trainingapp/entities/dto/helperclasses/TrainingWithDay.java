package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.TrainingeventEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrainingWithDay {
  private   TrainingEntity trainingEntity;
   private TrainingeventEntity day;
}
