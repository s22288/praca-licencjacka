const GetMealByMealType = (type) => {
    return fetch(
        `http://localhost:9800/create-diet/getMeals-byType?typeid=${type}`

    );
};

export { GetMealByMealType };