package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.PremiumuserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface PremiumUserSerivice {
    PremiumuserEntity findById(long id);
    PremiumuserEntity findByEmail(String email);
    void save(PremiumuserEntity premiumuser);

    void removeAllAssociations(long id);
}
