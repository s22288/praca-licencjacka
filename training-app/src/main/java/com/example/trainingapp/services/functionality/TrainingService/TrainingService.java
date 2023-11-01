package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TrainingService {

     List<TrainingEntity> getAllUserTraining(int userId);
     void deleteTrainingById(long trainingId);

     List<ExerciseWithAlternatives> findExerciseWithAlternativesForEachBodyPart();


     void saveTraining(TrainingEntity trainingEntity);
     TrainingeventEntity getTrainingById(long id);

     List<TrainingWithDay> getTrainigsWithDays(long id);

     void saveTrainingEvent(TrainingeventEntity trainingeventEntity);
   //  List<String> getAllTrainingtypes();

     void saveMaxInExercise(MaxinexerciseEntity maxinexerciseEntity);
     TrainingmachineEntity findMachineById(long id);

//     Map<String,List<ExerciseWithAlternatives>> createSplitTraining();

     Map<String,List<ExerciseWithAlternatives>> createSplitTraining();

}
