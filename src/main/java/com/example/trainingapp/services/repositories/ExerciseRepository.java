package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.ExerciseEntity;
import com.example.trainingapp.entities.MealEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Long> {
    @Procedure(procedureName = "insertExercises")
    void insertExercises(@Param("countExercises") int countExercises);


    @Query(value = "select  e.id, e.level_of_advance,e.reps,e.series,e.training_machine_id,e.name,e.photo,e.day_name from  exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join bodypart b on eb.body_part_id = b.id where b.description = ?1  order by RAND() limit 1 ",nativeQuery = true)
    ExerciseEntity findRandomExerciseFromBodyPart(String bodyPart);


    @Query(value = "select  e.id, e.level_of_advance,e.reps,e.series,e.training_machine_id,e.name,e.photo,e.day_name from  exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join bodypart b on eb.body_part_id = b.id where b.description = ?1 and e.id != ?2 order by RAND() limit 2 ",nativeQuery = true)
    List<ExerciseEntity> findTwoAlternatives(String bodyPart, int used);

    @Query(value = "select  e.id, e.level_of_advance,e.reps,e.series,e.training_machine_id,e.name,e.photo,e.day_name  from  exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join bodypart b on eb.body_part_id = b.id where b.description = ?1 order by RAND() limit 2 ",nativeQuery = true)
    List<ExerciseEntity> findTwoAlternativesWithoutUsed(String bodyPart);

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Klatka piersiowa' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForChest();

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Triceps' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForTriceps();

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Nogi' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForLegs();

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Plecy' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForBack();

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Ramiona' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForArms();


    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Brzuch' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForAbs();

    @Query(value = "SELECT e.* " +
            "FROM exercise e " +
            "INNER JOIN exercisebodypart eb ON e.id = eb.exercise_id " +
            "INNER JOIN bodypart b ON eb.body_part_id = b.id " +
            "WHERE b.description = 'Barki' " +
            "LIMIT 3", nativeQuery = true)
    List<ExerciseEntity> findTop3ExercisesForShoulders();


    @Query(value = "select  b.description from exercisebodypart eb inner join bodypart b on eb.body_part_id = b.id where eb.exercise_id = :id ", nativeQuery = true)
    String findBodyPart(@Param("id") int id);

    @Query(value = "select *from exercise ",nativeQuery = true)
    Page<ExerciseEntity> findAllPeagable(Pageable pageable);

}
