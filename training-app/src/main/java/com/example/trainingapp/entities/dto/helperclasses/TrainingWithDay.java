package com.example.trainingapp.entities.dto.helperclasses;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.TrainingeventEntity;
import lombok.*;

@Getter
@Setter
@ToString


public class TrainingWithDay {
  private   TrainingEntity trainingEntity;
   private TrainingeventEntity day;

    public TrainingWithDay(TrainingEntity trainingEntity, TrainingeventEntity day) {
        this.trainingEntity = trainingEntity;
        this.day = day;
    }

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

    public TrainingWithDay() {
    }
}
