const GetMealByMealType = (type, goalCalories) => {
    return fetch(
        `http://localhost:9800/create-diet/getMeals-byType?typeid=${type}&calories=${goalCalories}`

    );
};

export { GetMealByMealType };