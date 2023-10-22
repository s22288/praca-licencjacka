package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.TrainingeventEntity;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {

     List<TrainingEntity> getAllUserTraining(int userId);
     void deleteTrainingById(long trainingId);

     List<ExerciseWithAlternatives> findExerciseWithAlternativesForEachBodyPart();


     void saveTraining(TrainingEntity trainingEntity);
     TrainingeventEntity getTrainingById(long id);

     List<TrainingWithDay> getTrainigsWithDays(int id);
   //  List<String> getAllTrainingtypes();
}
