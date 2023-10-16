package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.controllers.NormalUserController;
import com.example.trainingapp.entities.MaxinexerciseEntity;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.PremiumuserEntity;
import com.example.trainingapp.entities.dto.Indicator;
import com.example.trainingapp.services.repositories.MaxInExerciseRepository;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import com.example.trainingapp.services.repositories.UserRepository;
import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);

   private UserRepository userRepository;
   private MaxInExerciseRepository maxInExerciseRepository;
   private PremiumUserRepository premiumUserRepository;

    public UserServiceImplementation(UserRepository userRepository, MaxInExerciseRepository maxInExerciseRepository, PremiumUserRepository premiumUserRepository) {
        this.userRepository = userRepository;
        this.maxInExerciseRepository = maxInExerciseRepository;
        this.premiumUserRepository = premiumUserRepository;
    }

    @Override
    public int calculateAge(int id) {

        return userRepository.getUserAgeById(id);
    }

    @Override
    public List<MaxinexerciseEntity> getUsersMaxes(int idOfUser) {
        return maxInExerciseRepository.getUserMaxes(idOfUser);
    }

    @Override
    public Indicator calculateIndicators(int userId) {
        PremiumuserEntity userFromDB = premiumUserRepository.findById((long) userId).get();
        double BMI = calculateBMI(userFromDB.getHeight(),userFromDB.getWeight());
        logger.info("BMI" + BMI);
        double IBW = calculateIBW(userFromDB.isSex(),userFromDB.getHeight());
        double Weight = userFromDB.getWeight();
        double Height = userFromDB.getHeight();
        String WHR = calculateWHR(userFromDB.getWaistCircumference(),userFromDB.getHipsCircumference(),userFromDB.isSex());
       return Indicator.builder().BMI(BMI).IBW(IBW).WHR(WHR).Weight(Weight).Height(Height/100).build();

    }



    public  double calculateBMI(double weight, double height){
        logger.info("weight " + weight);
        logger.info("height " + height);
        logger.info("pow 2 " + Math.pow(height,2));

        return Precision.round(weight/ Math.pow(height,2)*1000,2);

    }
    public double  calculateIBW(boolean sex, double height){
        if(sex){
            double value =     (height - 100);
            return Precision.round( value- (0.10 * value),2);
        }
        double value =     (height - 100);

        return  Precision.round(value- (0.05 * value),2);
    }

    public String calculateWHR(double waistCircumference, double hipsCircumference,boolean sex ){
        double WHR = waistCircumference/ hipsCircumference;

        if(sex){
            if(WHR>1){
                return "Otyłość aneroidalna(jabłko)";
            }
            return "Otyłość ginoidalna gruszka";
        }

        if(WHR>0.8){
            return "Otyłość aneroidalna(jabłko)";

        }
        return "Otyłość aneroidalna(jabłko)";

    }




}
