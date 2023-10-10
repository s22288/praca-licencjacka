package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.services.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImplementation implements UserService {

   private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int calculateAge(int id) {

        return userRepository.getUserAgeById(id);
    }



}
