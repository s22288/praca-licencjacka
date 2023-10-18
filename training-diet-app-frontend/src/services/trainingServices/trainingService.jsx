const GetAllTrainings = () => {
    return fetch("http://localhost:8080/api/public/user-page/diets");

};

const DelteteTrainigById = () => {
    return 'delete'
}
export { GetAllTrainings, DelteteTrainigById }