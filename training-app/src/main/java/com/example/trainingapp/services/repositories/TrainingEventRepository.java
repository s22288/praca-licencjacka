package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingeventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingEventRepository extends JpaRepository<TrainingeventEntity,Long> {
}
