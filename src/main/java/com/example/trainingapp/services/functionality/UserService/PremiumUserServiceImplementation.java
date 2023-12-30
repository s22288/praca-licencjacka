package com.example.trainingapp.services.functionality.UserService;

import com.example.trainingapp.entities.PremiumuserEntity;
import com.example.trainingapp.services.repositories.PremiumUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class PremiumUserServiceImplementation implements PremiumUserSerivice {
    private PremiumUserRepository premiumUserRepository;


    public PremiumUserServiceImplementation(PremiumUserRepository premiumUserRepository) {
        this.premiumUserRepository = premiumUserRepository;
    }

    @Override
    public PremiumuserEntity findById(long id) {
        return premiumUserRepository.findById(id).get();
    }

    @Override
    public PremiumuserEntity findByEmail(String email) {
        return premiumUserRepository.findByEmail(email).get();
    }

    @Override
    public void save(PremiumuserEntity premiumuser) {
        premiumUserRepository.save(premiumuser);
    }

    @Override
    public void removeAllAssociations(long premiumUserId) {
        Optional<PremiumuserEntity> optionalPremiumUser = premiumUserRepository.findById(premiumUserId);

        optionalPremiumUser.ifPresent(premiumUser -> {
            premiumUser.setTrainingeventEntitySet(new HashSet<>());
            premiumUserRepository.save(premiumUser);
        });
    }
}
