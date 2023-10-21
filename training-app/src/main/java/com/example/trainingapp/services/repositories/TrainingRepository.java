package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository <TrainingEntity,Long> {
    @Query(value ="select  * from training    where normal_user_id = ?1" ,nativeQuery = true)
     List<TrainingEntity> getALLUsersTrainings(int userId);
    @Query(value =  "select distinct t.treining_type from training t ",nativeQuery = true)
    List<String> getTrainingTypes();
}
