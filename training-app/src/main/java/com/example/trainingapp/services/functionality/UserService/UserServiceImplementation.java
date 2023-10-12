package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.services.repositories.MaxInExerciseRepository;
import com.example.trainingapp.services.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

   private UserRepository userRepository;
   private MaxInExerciseRepository maxInExerciseRepository;

    public UserServiceImplementation(UserRepository userRepository, MaxInExerciseRepository maxInExerciseRepository) {
        this.userRepository = userRepository;
        this.maxInExerciseRepository = maxInExerciseRepository;
    }

    @Override
    public int calculateAge(int id) {

        return userRepository.getUserAgeById(id);
    }

    @Override
    public List<MaxinexerciseEntity> getUsersMaxes(int idOfUser) {
        return maxInExerciseRepository.getUserMaxes(idOfUser);
    }


}
