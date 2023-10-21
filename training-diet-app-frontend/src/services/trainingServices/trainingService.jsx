const GetAllTrainings = () => {
    return fetch("http://localhost:9800/normal-user/trainings");

};


const SaveTrainig = (training) => {
    fetch("http://localhost:9800/create-training/save-training", {
        method: "POST",
        headers: {

            'Content-Type': 'application/json'
        },
        body: JSON.stringify(training),
    });
};
const GetExerciseseByBodyPart=()=>{
    return fetch("http://localhost:9800/create-training/exercise-for-bodyparts");
}
const DelteteTrainigById = (id) => {
    return fetch(`http://localhost:9800/normal-user/delete-training/${id}`, {
       
});




}

export { GetAllTrainings, DelteteTrainigById, GetExerciseseByBodyPart,SaveTrainig}