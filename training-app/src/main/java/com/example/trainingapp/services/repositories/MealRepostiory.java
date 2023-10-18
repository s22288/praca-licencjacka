package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepostiory extends JpaRepository<MealEntity,Long> {
    @Procedure(procedureName = "InsertData")
    void InsertMeals(@Param("countMeals") int countMeals);


    @Query (value = "select * from meal where meal_type_id=?1 limit 4",nativeQuery = true)
    List<MealEntity> findFourMealsBaseOnType(int typeId);


    @Query (value = "select * from meal m inner  join dietmeals d on m.id = d.meal_id and d.diet_id = ?1",nativeQuery = true)
    List<MealEntity> findAllMealsOfDiet(int dietId);
}
