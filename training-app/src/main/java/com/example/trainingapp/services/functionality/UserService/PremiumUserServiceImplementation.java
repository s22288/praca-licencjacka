package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.PremiumuserEntity;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import org.springframework.stereotype.Service;

@Service
public class PremiumUserServiceImplementation implements  PremiumUserSerivice{
    private PremiumUserRepository premiumUserRepository;

    public PremiumUserServiceImplementation(PremiumUserRepository premiumUserRepository) {
        this.premiumUserRepository = premiumUserRepository;
    }

    @Override
    public PremiumuserEntity findById(long id) {
        return premiumUserRepository.findById(id).get();
    }
}
