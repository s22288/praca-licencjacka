const GetAllTrainings = () => {
    return fetch("http://localhost:9800/normal-user/trainings");

};

const DelteteTrainigById = (id) => {
    return fetch(`http://localhost:9800/normal-user/delete-training/${id}`, {
       
});
}
export { GetAllTrainings, DelteteTrainigById }