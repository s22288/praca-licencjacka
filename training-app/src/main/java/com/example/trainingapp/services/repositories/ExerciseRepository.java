package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Long> {
    @Procedure(procedureName = "insertExercises")
    void insertExercises(@Param("countExercises") int countExercises);
}
