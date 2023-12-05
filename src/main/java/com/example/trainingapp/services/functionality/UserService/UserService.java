package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.dto.helperclasses.Indicator;
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

     NormaluserEntity findUserByid(long id);
     NormaluserEntity findByEmail(String email);

     void saveUser(NormaluserEntity normaluserEntity);


     List<NormaluserEntity> getAllUsers();
     void deleteUser(long id);
}
