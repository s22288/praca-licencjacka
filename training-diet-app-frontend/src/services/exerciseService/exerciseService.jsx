const GetAllExercises = (page, size, order, sortpar) => {
    if (sortpar == null) {
        sortpar = 'id'
    }

    return fetch(
        `http://localhost:9800/admin-user/get-exercises?page=${page}&size=${size}&sort=${sortpar},${order}`
    )
}
const DeleteExerciseByid = (id) => {
    return fetch(`http://localhost:9800/admin-user/delete-exercise/${id}`, {

    });

}
export { GetAllExercises, DeleteExerciseByid };