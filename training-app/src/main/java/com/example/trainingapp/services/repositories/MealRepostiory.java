package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepostiory extends JpaRepository<MealEntity,Long> {
    @Procedure(procedureName = "InsertData")
    void InsertMeals(@Param("countMeals") int countMeals);
}
