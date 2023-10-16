package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.PremiumuserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumUserRepository extends JpaRepository<PremiumuserEntity,Long > {
}
