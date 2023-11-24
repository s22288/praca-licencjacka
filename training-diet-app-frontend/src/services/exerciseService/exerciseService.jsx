const GetAllExercises = (page, size, order, sortpar) => {
    if (sortpar == null) {
        sortpar = 'id'
    }
    const token = localStorage.getItem('jwtToken');


    return fetch(
        `http://localhost:9800/admin-user/get-exercises?page=${page}&size=${size}&sort=${sortpar},${order}`
        , {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`,
            },
            credentials: 'include',
        })
}
const DeleteExerciseByid = (id) => {
    const token = localStorage.getItem('jwtToken');

    return fetch(`http://localhost:9800/admin-user/delete-exercise/${id}`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include',
    });

}
export { GetAllExercises, DeleteExerciseByid };