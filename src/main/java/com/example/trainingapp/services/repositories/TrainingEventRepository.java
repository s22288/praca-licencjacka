package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingeventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingEventRepository extends JpaRepository<TrainingeventEntity,Long> {
    @Query(value = "select * from trainingevent inner join userstrainingevent u on trainingevent.id = u.training_calendar_id where u.premium_user_normal_user_id = ?1" ,nativeQuery = true)
    List<TrainingeventEntity> getEventByUserId(long id);
}
