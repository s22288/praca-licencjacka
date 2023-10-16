package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.entities.dto.Indicator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     int calculateAge(int id);

     List<MaxinexerciseEntity> getUsersMaxes(int idOfUser);

     Indicator calculateIndicators(int userId);


     double calculateBMI(double weight, double height);

     double calculateIBW(boolean sex, double height);


     String calculateWHR(double waistCircumference, double hipsCircumference,boolean sex);
}
