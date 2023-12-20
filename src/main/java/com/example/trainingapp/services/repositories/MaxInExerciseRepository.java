package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.MaxinexerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaxInExerciseRepository extends JpaRepository<MaxinexerciseEntity,Long> {
    @Query(value = "select * from maxinexercise m  where m.normal_user_id = ?1 order by m.day_of_records limit 5",nativeQuery = true)
    List<MaxinexerciseEntity> getUserMaxes (int idOfUser);
}
