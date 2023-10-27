package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietRepository extends JpaRepository<DietEntity,Long> {
    @Query(nativeQuery = true,value = "select * from diet where normal_user_id = ?1")
    List<DietEntity> findDietsByUserId(int userId);



}
