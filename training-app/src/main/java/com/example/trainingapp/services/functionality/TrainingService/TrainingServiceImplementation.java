package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.BodypartEntity;
import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.TrainingeventEntity;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.repositories.BodyPartRepository;
import com.example.trainingapp.services.repositories.ExerciseRepository;
import com.example.trainingapp.services.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingServiceImplementation implements  TrainingService{
    private TrainingRepository trainingRepository;

    private ExerciseRepository exerciseRepository;
    private BodyPartRepository bodyPartRepository;

    public TrainingServiceImplementation(TrainingRepository trainingRepository,ExerciseRepository exerciseRepository,BodyPartRepository bodyPartRepository) {
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.bodyPartRepository =bodyPartRepository;
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
    public List<TrainingWithDay> getTrainigsWithDays(int id) {
        return trainingRepository.getTrainingsWithDays(id);
    }

//    @Override
//    public List<String> getAllTrainingtypes() {
//        return trainingRepository.getTrainingTypes();
//    }
}
