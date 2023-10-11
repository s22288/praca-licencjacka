package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.DietEntity;
import org.springframework.stereotype.Service;

@Service
public interface DietService {
     Integer getDietBaseOnCaloriesAndDietType(int calories);
}
