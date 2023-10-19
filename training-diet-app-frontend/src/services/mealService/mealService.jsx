const GetMealByMealType = (type) => {
    return fetch(
        `http://localhost:9800/create-diet/getMeals-byType?typeid=${type}`

    );
};
const DelteteMealbyId = ( id) => {
    return fetch(`http://localhost:9800/normal-user/delete-diet/${id}`, {
       
    });
};

export { DelteteMealbyId, GetMealByMealType };