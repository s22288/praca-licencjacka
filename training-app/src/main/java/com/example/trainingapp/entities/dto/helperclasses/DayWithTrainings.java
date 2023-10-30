package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.ExerciseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DayWithTrainings {
    private Map<String,List<ExerciseEntity>> listOfExericsesAndDays;

}
