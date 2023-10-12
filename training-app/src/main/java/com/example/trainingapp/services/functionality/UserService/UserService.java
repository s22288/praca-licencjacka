package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     int calculateAge(int id);

     List<MaxinexerciseEntity> getUsersMaxes(int idOfUser);
}
