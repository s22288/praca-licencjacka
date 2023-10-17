const GetMealByMealType = (type) => {
    return fetch(
        `http://localhost:9800/create-diet/getMeals-byType?typeid=${type}`

    );
};
const DelteteMealbyId = (username, password, id) => {
    return fetch(`http://localhost:8080/api/public/user-page/delete-diet/${id}`, {
        headers: {
            Authorization: "Basic " + btoa(`${username}:${password}`),
        },
    });
};

export { DelteteMealbyId, GetMealByMealType };