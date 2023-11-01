package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.controllers.TrainingController;
import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.DayWithTrainings;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainingServiceImplementation implements TrainingService {
    private TrainingRepository trainingRepository;
    private MachineRepository machineRepository;

    private ExerciseRepository exerciseRepository;
    private BodyPartRepository bodyPartRepository;
    private TrainingEventRepository trainingEventRepository;

    private MaxInExerciseRepository maxInExerciseRepository;
    private static final Logger logger = LoggerFactory.getLogger(TrainingServiceImplementation.class);


    public TrainingServiceImplementation(TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, BodyPartRepository bodyPartRepository, TrainingEventRepository trainingEventRepository, MaxInExerciseRepository maxInExerciseRepository, MachineRepository machineRepository) {
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.bodyPartRepository = bodyPartRepository;
        this.trainingEventRepository = trainingEventRepository;
        this.maxInExerciseRepository = maxInExerciseRepository;
        this.machineRepository = machineRepository;
    }

    @Override
    public List<TrainingEntity> getAllUserTraining(int userId) {
        return trainingRepository.getALLUsersTrainings(userId);
    }

    @Override
    public void deleteTrainingById(long trainingId) {
        trainingRepository.deleteById(trainingId);
    }

    @Override
    public List<ExerciseWithAlternatives> findExerciseWithAlternativesForEachBodyPart() {
        List<ExerciseWithAlternatives> eachBodyPartExercise = new ArrayList<>();

        List<BodypartEntity> allBodyPart = bodyPartRepository.findAll();

        allBodyPart.forEach(b -> {
            ExerciseEntity exercise = exerciseRepository.findRandomExerciseFromBodyPart(b.getDescription());

            List<ExerciseEntity> alternatives = exerciseRepository.findTwoAlternatives(b.getDescription(), exercise.getId());
            ExerciseWithAlternatives exerciseWithAlternatives = ExerciseWithAlternatives.builder().exerciseEntity(exercise).alternatives(alternatives).build();

            eachBodyPartExercise.add(exerciseWithAlternatives);
        });
        return eachBodyPartExercise;
    }

    @Override
    public void saveTraining(TrainingEntity trainingEntity) {
        trainingRepository.save(trainingEntity);
    }

    @Override
    public TrainingeventEntity getTrainingById(long id) {
        trainingRepository.findById(id);
        return null;
    }

    @Override
    public List<TrainingWithDay> getTrainigsWithDays(long id) {
        return trainingRepository.getTrainingsWithDays(id);
    }

    @Override
    public void saveTrainingEvent(TrainingeventEntity trainingeventEntity) {
        trainingEventRepository.save(trainingeventEntity);
    }

    @Override
    public void saveMaxInExercise(MaxinexerciseEntity maxinexerciseEntity) {
        maxInExerciseRepository.save(maxinexerciseEntity);
    }

    @Override
    public TrainingmachineEntity findMachineById(long id) {

        return machineRepository.findById(id).get();
    }



    @Override
    public Map<String, List<ExerciseWithAlternatives>> createSplitTraining() {

        Map<String, List<ExerciseWithAlternatives>> mapOfDaysAndExericses = new HashMap<>();

//

        List<ExerciseEntity> chestExerciseses = exerciseRepository.findTop3ExercisesForChest();
        List<ExerciseWithAlternatives> alternativesForChest = findAlternativesForlistofExercises(chestExerciseses);
        List<ExerciseEntity> tricepsExerciseses = exerciseRepository.findTop3ExercisesForTriceps();
        List<ExerciseWithAlternatives> alternativesForTriceps = findAlternativesForlistofExercises(tricepsExerciseses);

        // biceps plecy
        List<ExerciseEntity> backExerciseses = exerciseRepository.findTop3ExercisesForBack();
        List<ExerciseWithAlternatives> alternativesForBack = findAlternativesForlistofExercises(backExerciseses);

        List<ExerciseEntity> armsExerciseses = exerciseRepository.findTop3ExercisesForArms();
        List<ExerciseWithAlternatives> alternativesForArms = findAlternativesForlistofExercises(armsExerciseses);

        // nogi i barki
        List<ExerciseEntity> legsExerciseses = exerciseRepository.findTop3ExercisesForLegs();
        List<ExerciseWithAlternatives> alternativesForLegs = findAlternativesForlistofExercises(legsExerciseses);

        List<ExerciseEntity> shouldersExerciseses = exerciseRepository.findTop3ExercisesForShoulders();
        List<ExerciseWithAlternatives> alternativesForShoulders = findAlternativesForlistofExercises(shouldersExerciseses);

        List<ExerciseEntity> absExerciseses = exerciseRepository.findTop3ExercisesForAbs();
        List<ExerciseWithAlternatives> alternativesForAbs = findAlternativesForlistofExercises(absExerciseses);

        mapOfDaysAndExericses.computeIfAbsent("one", k -> new ArrayList<>()).addAll(alternativesForChest);
        mapOfDaysAndExericses.computeIfAbsent("one", k -> new ArrayList<>()).addAll(alternativesForTriceps);
        mapOfDaysAndExericses.computeIfAbsent("one", k -> new ArrayList<>()).addAll(alternativesForAbs);
        mapOfDaysAndExericses.computeIfAbsent("two", k -> new ArrayList<>()).addAll(alternativesForBack);
        mapOfDaysAndExericses.computeIfAbsent("two", k -> new ArrayList<>()).addAll(alternativesForArms);
        mapOfDaysAndExericses.computeIfAbsent("two", k -> new ArrayList<>()).addAll(alternativesForAbs);
        mapOfDaysAndExericses.computeIfAbsent("three", k -> new ArrayList<>()).addAll(alternativesForLegs);
        mapOfDaysAndExericses.computeIfAbsent("three", k -> new ArrayList<>()).addAll(alternativesForShoulders);
        mapOfDaysAndExericses.computeIfAbsent("three", k -> new ArrayList<>()).addAll(alternativesForAbs);


        return mapOfDaysAndExericses;
    }

    public List<ExerciseWithAlternatives> findAlternativesForlistofExercises(List<ExerciseEntity> exerciseEntities) {
        List<ExerciseWithAlternatives> eachBodyPartExercise = new ArrayList<>();

        exerciseEntities.forEach(b -> {
           String bodyPart = exerciseRepository.findBodyPart(b.getId());
        logger.info("bodypart " + bodyPart + " of id " + b.getId());

            List<ExerciseEntity> alternatives3 = exerciseRepository.findTwoAlternativesWithoutUsed(exerciseRepository.findBodyPart(b.getId()));
            ExerciseWithAlternatives exerciseWithAlternatives3 = ExerciseWithAlternatives.builder().exerciseEntity(b).alternatives(alternatives3).build();
            exerciseWithAlternatives3.setAlternatives(alternatives3);

            eachBodyPartExercise.add(exerciseWithAlternatives3);


        });
        return eachBodyPartExercise;
    }


}
