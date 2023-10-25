package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
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
    @Query(value = "select t.id, t.max_age, t.treining_type, t.description, te.description, te.id, te.day, te.localozation from training t inner join normaluser n on t.normal_user_id = n.id inner join premiumuser p on n.id = p.id inner join userstrainingevent ue on p.id = ue.premium_user_normal_user_id inner join trainingevent te on ue.training_calendar_id = te.id where n.id= ?1", nativeQuery = true)
    List<TrainingWithDay> getTrainingsWithDays(long userId);

}
