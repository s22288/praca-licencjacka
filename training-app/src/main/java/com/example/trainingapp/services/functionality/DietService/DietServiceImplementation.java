package com.example.trainingapp.services.functionality.DietService;

import com.example.trainingapp.entities.AlergicingridientsEntity;
import com.example.trainingapp.entities.DietEntity;
import com.example.trainingapp.entities.MealEntity;
import com.example.trainingapp.entities.MealtypeEntity;
import com.example.trainingapp.entities.dto.helperclasses.DietWithMeals;
import com.example.trainingapp.entities.dto.helperclasses.MealWithAlternatives;
import com.example.trainingapp.services.functionality.TrainingService.TrainingServiceImplementation;
import com.example.trainingapp.services.repositories.DietRepository;
import com.example.trainingapp.services.repositories.MealRepostiory;
import com.example.trainingapp.services.repositories.MealTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class DietServiceImplementation implements DietService {


    private MealRepostiory mealRepostiory;

    private MealTypeRepository mealTypeRepository;

    private List<MealEntity> used = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(DietServiceImplementation.class);

    private DietRepository dietRepository;

    public DietServiceImplementation(MealRepostiory mealRepostiory, MealTypeRepository mealTypeRepository, DietRepository dietRepository) {
        this.mealRepostiory = mealRepostiory;
        this.mealTypeRepository = mealTypeRepository;
        this.dietRepository = dietRepository;
    }

    @Override
    public List<MealEntity> getDietBaseOnCaloriesAndDietType(int maxCalories) {
        int upper = maxCalories + 50;
        int lowwer = maxCalories - 50;
        AtomicInteger suma = new AtomicInteger();
        List<MealEntity> mealBaseOnCalories = new ArrayList<>();
        mealRepostiory.findAll().forEach(
                mealEntity -> {
                    int mealCalories = mealEntity.getCalories();
                    if ((lowwer > suma.get()) && (suma.get() < upper)) {
                        suma.addAndGet(mealCalories);
                        mealBaseOnCalories.add(mealEntity);


                    }
                }
        );
        logger.info("lista " + mealBaseOnCalories);
        return mealBaseOnCalories;
    }

    @Override
    public List<MealWithAlternatives> findForuMealsBaseOnMealType(int typeId,int calories) {
        logger.info("calories " + calories);
        List<MealWithAlternatives> mealAndAlternatives = new ArrayList<>();
//        List<MealEntity> findFourMeals = mealRepostiory.findAll().stream().filter(m -> m.getMealTypeId() == typeId).limit(4).toList();
        List<MealEntity> findFourMeals = getDietBaseOnCaloriesAndDietType(calories);
List<AlergicingridientsEntity> alergicingridientsEntityList = new ArrayList<>();
        used.addAll(findFourMeals);
        findFourMeals.forEach(t -> {
            MealWithAlternatives alternatives = new MealWithAlternatives();

            alternatives.setMealEntity(t);
            List<MealEntity> different = findDifferent(used, t.getMealTypeId());
            alergicingridientsEntityList.addAll(t.getAlergicingridientsEntitySet());
            different.forEach( d->{
                alergicingridientsEntityList.addAll(d.getAlergicingridientsEntitySet());
            });
            alternatives.setAlternatives(different);
            mealAndAlternatives.add(alternatives);

        });
        List<AlergicingridientsEntity> distinctAlergens = alergicingridientsEntityList.stream().distinct().toList();
        mealAndAlternatives.get(0).setAllAlergics(distinctAlergens);
        return mealAndAlternatives;

    }


    public List<MealEntity> findDifferent(List<MealEntity> base, int mealType) {
        List<MealEntity> differentTwo = mealRepostiory.findAll();
        differentTwo.removeAll(base);
        List<MealEntity> limited = differentTwo.stream().filter(t -> t.getMealTypeId() == mealType).limit(2).collect(Collectors.toList());
        if (limited.size() == 2) {
            used.add(limited.get(0));
            used.add(limited.get(1));
        }

        return limited;
    }

    @Override
    public List<MealtypeEntity> findAllTypeOfMeal() {
        return mealTypeRepository.findAll();
    }

    @Override
    public List<DietWithMeals> findDietsByUserIdWithMeals(int userId) {

        List<DietWithMeals> mealWithAlternatives = new ArrayList<>();
        List<DietEntity> dietsByUserId = dietRepository.findDietsByUserId(userId);
        for (DietEntity dietEntity : dietsByUserId) {
            DietEntity diet = dietEntity;
            List<MealEntity> allMealsOfDiet = mealRepostiory.findAllMealsOfDiet(dietEntity.getId());
            DietWithMeals dietWithMeals = DietWithMeals.builder().dietEntity(diet).mealEntityList(allMealsOfDiet).build();
            mealWithAlternatives.add((dietWithMeals));
        }
        return mealWithAlternatives;
    }

    @Override
    public void saveDiet(DietEntity dietEntity) {
dietRepository.save(dietEntity);
    }

    @Override
    public void deleteDietById(long id) {
        dietRepository.deleteById(id);
    }

    @Override
    public List<AlergicingridientsEntity> findAllAlergens(List<MealEntity> mealEntityList) {
        Set<AlergicingridientsEntity> uniqueAlergicIngridients = new HashSet<>();
        List<Set<AlergicingridientsEntity>> setofAlergics = mealEntityList.stream().map(MealEntity::getAlergicingridientsEntitySet).toList();
        setofAlergics.forEach(uniqueAlergicIngridients::addAll);
        return uniqueAlergicIngridients.stream().toList();
    }

    @Override
    public List<MealEntity> getAllMeals() {
        return mealRepostiory.findAll();
    }



    @Override
    public List<MealEntity> getAllPageable(Pageable pageable) {
        return mealRepostiory.findAllPeagable(pageable).stream().toList();
    }

    @Override
    public void deleteMealByid(long id) {
        mealRepostiory.deleteById(id);
    }
}
