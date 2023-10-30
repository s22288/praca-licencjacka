package com.example.trainingapp.services.functionality.TrainingService;

import com.example.trainingapp.entities.*;
import com.example.trainingapp.entities.dto.helperclasses.DayWithTrainings;
import com.example.trainingapp.entities.dto.helperclasses.ExerciseWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.entities.dto.helperclasses.TrainingWithDay;
import com.example.trainingapp.services.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainingServiceImplementation implements  TrainingService{
    private TrainingRepository trainingRepository;
    private  MachineRepository machineRepository;

    private ExerciseRepository exerciseRepository;
    private BodyPartRepository bodyPartRepository;
    private TrainingEventRepository trainingEventRepository;

    private MaxInExerciseRepository maxInExerciseRepository;

    public TrainingServiceImplementation(TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, BodyPartRepository bodyPartRepository, TrainingEventRepository trainingEventRepository, MaxInExerciseRepository maxInExerciseRepository,MachineRepository machineRepository) {
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

        List<BodypartEntity> allBodyPart  = bodyPartRepository.findAll();

        allBodyPart.forEach( b->{
            ExerciseEntity exercise =   exerciseRepository.findRandomExerciseFromBodyPart(b.getDescription());

List<ExerciseEntity> alternatives =exerciseRepository.findTwoAlternatives(b.getDescription(),exercise.getId());
            ExerciseWithAlternatives exerciseWithAlternatives  = ExerciseWithAlternatives.builder().exerciseEntity(exercise).alternatives(alternatives).build();

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
    public Map<String,List<MealWithAlternatives>>createSplitTraining() {
        List<ExerciseWithAlternatives> exerciseWithAlternatives = new ArrayList<>();


        // barki triceps
        List<ExerciseEntity> chestExerciseses = exerciseRepository.findTop3ExercisesForChest();
        List<ExerciseEntity> tricepsExerciseses = exerciseRepository.findTop3ExercisesForTriceps();
        // biceps plecy
        List<ExerciseEntity> backExerciseses = exerciseRepository.findTop3ExercisesForBack();
        List<ExerciseEntity> armsExerciseses = exerciseRepository.findTop3ExercisesForArms();
        // nogi i barki
        List<ExerciseEntity> legsExerciseses = exerciseRepository.findTop3ExercisesForLegs();
        List<ExerciseEntity> shouldersExerciseses = exerciseRepository.findTop3ExercisesForShoulders();
        List<ExerciseEntity> absExerciseses = exerciseRepository.findTop3ExercisesForAbs();
        DayWithTrainings dayWithTrainings  = new DayWithTrainings();
        dayWithTrainings.setListOfExericsesAndDays(null);
        List<ExerciseEntity> chestAndTriceps = new ArrayList<>();
        chestAndTriceps.addAll(chestExerciseses);
        chestAndTriceps.addAll(tricepsExerciseses);


        List<ExerciseEntity> backWithBiceps = new ArrayList<>();
        backWithBiceps.addAll(backExerciseses);
        backWithBiceps.addAll(armsExerciseses);

        List<ExerciseEntity> shouldersWithLegsAndAbs = new ArrayList<>();

        shouldersWithLegsAndAbs.addAll(legsExerciseses);
        shouldersWithLegsAndAbs.addAll(shouldersExerciseses);
        shouldersWithLegsAndAbs.addAll(absExerciseses);

        Map<String,List<MealWithAlternatives>> listOfExericsesAndDays = new HashMap<>();
        listOfExericsesAndDays.put("first",chestAndTriceps);
        listOfExericsesAndDays.put("second",backWithBiceps);
        listOfExericsesAndDays.put("third",shouldersWithLegsAndAbs);





        return  listOfExericsesAndDays;
    }



}
