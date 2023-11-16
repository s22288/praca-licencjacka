const GetMealByMealType = (type, goalCalories) => {
    return fetch(
        `http://localhost:9800/create-diet/getMeals-byType?typeid=${type}&calories=${goalCalories}`

    );


};

const GetAllMeals = (page, size, order) => {
    return fetch(
        `http://localhost:9800/admin-user/get-meals?page=${page}&size=${size}&sort=id,${order}`
    )
}

const DeleteMealByid = (id) => {
    return fetch(`http://localhost:9800/admin-user/delete-meal/${id}`, {

    });

}

export { GetMealByMealType, GetAllMeals, DeleteMealByid };