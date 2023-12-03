package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.PremiumuserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PremiumUserRepository extends JpaRepository<PremiumuserEntity,Long > {
    Optional<PremiumuserEntity> findByEmail(String email);
}
