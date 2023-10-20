package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.TrainingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {

     List<TrainingEntity> getAllUserTraining(int userId);
     void deleteTrainingById(long trainingId);
}
