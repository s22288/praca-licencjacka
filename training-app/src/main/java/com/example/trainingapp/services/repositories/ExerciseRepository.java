package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.ExerciseEntity;
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


    @Query(value = "select  e.id, e.level_of_advance,e.reps,e.series,e.training_machine_id,e.name,e.photo from  exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join bodypart b on eb.body_part_id = b.id where b.description = ?1  order by RAND() limit 1 ",nativeQuery = true)
    ExerciseEntity findRandomExerciseFromBodyPart(String bodyPart);


    @Query(value = "select  e.id, e.level_of_advance,e.reps,e.series,e.training_machine_id,e.name,e.photo from  exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join bodypart b on eb.body_part_id = b.id where b.description = ?1 and e.id != ?2 order by RAND() limit 2 ",nativeQuery = true)
    List<ExerciseEntity> findTwoAlternatives(String bodyPart, int used);


    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id where b.description = 'Klatka piersiowa' limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeChestExerciseses();


    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id =  b.id  where b.description = 'Triceps' limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeTricepsExerciseses();


    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id   where b.description = 'Nogi' limit 3 ",nativeQuery = true)
    List<ExerciseEntity> ThreeLegsExerciseses();


    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id   where b.description = 'Plecy' limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeBackExerciseses();

    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id   where b.description = 'Ramiona'  limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeArmsExerciseses();


    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id   where b.description = 'Brzuch' limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeAbsExerciseses();

    @Query(value = "select * from exercise e inner join exercisebodypart eb on e.id = eb.exercise_id inner join  bodypart b on eb.body_part_id = b.id   where b.description = 'Barki' limit 3",nativeQuery = true)
    List<ExerciseEntity> ThreeShouldersExerciseses();
}
