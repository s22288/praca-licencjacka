package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingServiceImplementation implements  TrainingService{
    private TrainingRepository trainingRepository;

    private ExerciseRepository exerciseRepository;
    private BodyPartRepository bodyPartRepository;
    private TrainingEventRepository trainingEventRepository;

    private MaxInExerciseRepository maxInExerciseRepository;

    public TrainingServiceImplementation(TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, BodyPartRepository bodyPartRepository, TrainingEventRepository trainingEventRepository, MaxInExerciseRepository maxInExerciseRepository) {
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.bodyPartRepository = bodyPartRepository;
        this.trainingEventRepository = trainingEventRepository;
        this.maxInExerciseRepository = maxInExerciseRepository;
    }

    @Override
    public List<TrainingEntity> getAllUserTraining(int userId) {
        return trainingRepository.getALLUsersTrainings(userId);
    }

    @Override
    public void deleteTrainingById(long trainingId) {
trainingRepository.deleteById(trainingId);
    }

    @Override
    public List<ExerciseWithAlternatives> findExerciseWithAlternativesForEachBodyPart() {
        List<ExerciseWithAlternatives> eachBodyPartExercise = new ArrayList<>();

        List<BodypartEntity> allBodyPart  = bodyPartRepository.findAll();

        allBodyPart.forEach( b->{
            ExerciseEntity exercise =   exerciseRepository.findRandomExerciseFromBodyPart(b.getDescription());

List<ExerciseEntity> alternatives =exerciseRepository.findTwoAlternatives(b.getDescription(),exercise.getId());
            ExerciseWithAlternatives exerciseWithAlternatives  = ExerciseWithAlternatives.builder().exerciseEntity(exercise).alternatives(alternatives).build();

        eachBodyPartExercise.add(exerciseWithAlternatives);
        });
        return eachBodyPartExercise;
    }

    @Override
    public void saveTraining(TrainingEntity trainingEntity) {
trainingRepository.save(trainingEntity);
    }

    @Override
    public TrainingeventEntity getTrainingById(long id) {
trainingRepository.findById(id);
        return null;
    }

    @Override
    public List<TrainingWithDay> getTrainigsWithDays(long id) {
        return trainingRepository.getTrainingsWithDays(id);
    }

    @Override
    public void saveTrainingEvent(TrainingeventEntity trainingeventEntity) {
        trainingEventRepository.save(trainingeventEntity);
    }

    @Override
    public void saveMaxInExercise(MaxinexerciseEntity maxinexerciseEntity) {
        maxInExerciseRepository.save(maxinexerciseEntity);
    }

//    @Override
//    public List<String> getAllTrainingtypes() {
//        return trainingRepository.getTrainingTypes();
//    }
}
