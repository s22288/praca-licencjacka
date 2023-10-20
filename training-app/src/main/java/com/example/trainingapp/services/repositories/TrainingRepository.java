package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository <TrainingEntity,Long> {
    @Query(value ="select  * from training  t  where t.normal_user_id = ?1" ,nativeQuery = true)
     List<TrainingEntity> getALLUsersTrainings(int userId);
}
