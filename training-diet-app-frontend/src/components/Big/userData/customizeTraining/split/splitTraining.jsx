
import { useState } from "react";
import CustomExcercises from "../exercise/exerciseCustom";

const SplitTraining = (props) => {
    const [userData, setUserData] = useState(props.data);


    const replaceData = (index, mainIndex) => {
        let userDataIndex = userData.findIndex((d) => {
            return d.exerciseEntity.id === mainIndex;
        });
        const updatedUserData = [...userData];
        const alternatives = updatedUserData[userDataIndex].alternatives;
        if (alternatives.length > 0) {
            let copy = updatedUserData[userDataIndex].exerciseEntity;
            updatedUserData[userDataIndex].exerciseEntity = alternatives[index];
            updatedUserData[userDataIndex].alternatives[index] = copy;
        }
        setUserData(updatedUserData);
    };
    return (
        <div>
            {Object.keys(userData).map(key => (
                userData[key].map(exercise => (
                    <div key={exercise.id}>
                        <p>ID: {exercise.id}</p>
                        <p>Name: {exercise.name}</p>
                    </div>
                ))
            ))}
        </div>
    );

}

export default SplitTraining