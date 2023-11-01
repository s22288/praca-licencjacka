package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.controllers.NormalUserController;
import com.example.trainingapp.entities.MealEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DietServiceImplementationTest {
@Autowired
    private DietServiceImplementation dietServiceImplementation;
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);

    @Test
    void getDietBaseOnCaloriesAndDietType() {
        List<MealEntity> dietBaseOnCaloriesAndDietType = dietServiceImplementation.getDietBaseOnCaloriesAndDietType(2000);
            logger.info("kcal " + dietBaseOnCaloriesAndDietType);
    }
}