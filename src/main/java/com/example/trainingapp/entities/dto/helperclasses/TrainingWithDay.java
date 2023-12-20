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
    private TrainingEntity trainingEntity;
    private TrainingeventEntity day;


    public TrainingEntity getTrainingEntity() {
        return trainingEntity;
    }

    public void setTrainingEntity(TrainingEntity trainingEntity) {
        this.trainingEntity = trainingEntity;
    }

    public TrainingeventEntity getDay() {
        return day;
    }

    public void setDay(TrainingeventEntity day) {
        this.day = day;
    }


}
