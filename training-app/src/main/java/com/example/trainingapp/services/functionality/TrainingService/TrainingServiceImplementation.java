package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.services.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImplementation implements  TrainingService{
    private TrainingRepository trainingRepository;

    public TrainingServiceImplementation(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<TrainingEntity> getAllUserTraining(int userId) {
        return trainingRepository.getALLUsersTrainings(userId);
    }

    @Override
    public void deleteTrainingById(long trainingId) {
trainingRepository.deleteById(trainingId);
    }

//    @Override
//    public List<String> getAllTrainingtypes() {
//        return trainingRepository.getTrainingTypes();
//    }
}
