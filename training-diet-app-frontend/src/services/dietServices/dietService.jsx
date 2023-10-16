const GetAllDiets = (username, password) => {
    return fetch("http://localhost:8080/api/public/user-page/diets", {
        headers: {
            Authorization: "Basic " + btoa(`${username}:${password}`),
        },
    });
};

const GetAllMealTypes = () => {
    return fetch("http://localhost:9800/create-diet/all-mealTypes")

}
const SaveDiet = (username, password, dietToSave) => {
    fetch("http://localhost:8080/api/public/user-page/save-diet", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",

            Authorization: "Basic " + btoa(`${username}:${password}`),
        },
        body: JSON.stringify(dietToSave),
    });
};

const CountCalories = (data) => {
    return data.reduce((start, next) => start + next.dish.calories, 0);
};
export { GetAllDiets, SaveDiet, CountCalories, GetAllMealTypes };