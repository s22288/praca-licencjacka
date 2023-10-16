package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.MealtypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends JpaRepository<MealtypeEntity,Long> {

}
