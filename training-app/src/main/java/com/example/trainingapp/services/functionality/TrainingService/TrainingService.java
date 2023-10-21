package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {

     List<TrainingEntity> getAllUserTraining(int userId);
     void deleteTrainingById(long trainingId);

     List<ExerciseWithAlternatives> findExerciseWithAlternativesForEachBodyPart();


     void saveTraining(TrainingEntity trainingEntity);
   //  List<String> getAllTrainingtypes();
}
