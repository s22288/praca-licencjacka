package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.TrainingEntity;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@SqlResultSetMapping(
        name = "TrainingWithDayMapping",
        classes = @ConstructorResult(
                targetClass = TrainingWithDay.class,
                columns = {
                        @ColumnResult(name = "training_id", type = Long.class),
                        @ColumnResult(name = "training_name", type = String.class),
                        @ColumnResult(name = "event_id", type = Long.class),
                        @ColumnResult(name = "event_day", type = String.class),
                        @ColumnResult(name = "event_description", type = String.class)

                }
        )
)
@Repository
public interface TrainingRepository extends JpaRepository <TrainingEntity,Long> {
    @Query(value ="select  * from training    where normal_user_id = ?1" ,nativeQuery = true)
     List<TrainingEntity> getALLUsersTrainings(int userId);
    @Query(value =  "select distinct t.treining_type from training t ",nativeQuery = true)
    List<String> getTrainingTypes();

    ;

    @Query(value = "SELECT new com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay(t, te) FROM TrainingEntity t " +
            "INNER JOIN NormaluserEntity n ON t.id = n.id " +
            "INNER JOIN PremiumuserEntity p ON n.id = p.id " +
            "INNER JOIN TrainingeventEntity te ON p MEMBER OF te.premiumuserEntitySet " +
            "WHERE n.id = ?1")
    List<TrainingWithDay> getTrainingsWithDays(long userId);

}
