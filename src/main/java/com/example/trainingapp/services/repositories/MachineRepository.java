package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingmachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<TrainingmachineEntity,Long> {
}
