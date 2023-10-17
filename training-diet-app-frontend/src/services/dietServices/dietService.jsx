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
const SaveDiet = (diet) => {
    fetch("http://localhost:9800/create-diet/save-diet", {
        method: "POST",
        headers: {

            'Content-Type': 'application/json'
        },
        body: JSON.stringify(diet),
    });
};

const CountCalories = (data) => {
    console.log(data)
    return data.reduce((start, next) => start + next.mealEntity.calories, 0);
};
export { GetAllDiets, SaveDiet, CountCalories, GetAllMealTypes };