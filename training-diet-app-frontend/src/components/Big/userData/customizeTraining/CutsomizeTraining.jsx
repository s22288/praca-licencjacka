import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./customization.css";
import Button from "@mui/material/Button";
import backgroundSVG from "../../../../assets/wave.svg"
import CustomExcercises from "./exercise/exerciseCustom";
import FunctionalityNavbar from "../../../Medium/navbar/functionalitynavbar";
import { GetExerciseseByBodyPart, SaveTrainig } from "../../../../services/trainingServices/trainingService";
const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState("");
  const [userData, setUserData] = useState();
  const navigate = useNavigate();
  const [trainingType, setTrainingType] = useState("");
const [description, setDescription] = useState('');
  const saveTrainig = (event) => {
    event.preventDefault();
    let exercises = userData.map((data) => data.exerciseEntity);
    console.log(exercises)
    const trainingToSave = {
      description: description,
      maxAge: 99,
      treiningType: excercise,
      exerciseEntitySet: exercises,
    };
   
    SaveTrainig( trainingToSave);
    navigate("/user-page");
  };
  const handleInput = (event) => {
    setDescription(event.target.value);
  };
  const HandleSubmit = (event) => {
    event.preventDefault();
    console.log(excercise)
    fetchUserData(excercise);
  };

  const handleChange = (event) => {
    const selectedExercise = event.target.value;
    setExcercise(selectedExercise);
  };
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
  const fetchUserData = () => {

    GetExerciseseByBodyPart( )
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to fetch user data");
        }
      })
      .then((data) => {
        setUserData(data);


       
      })
      .catch((error) => {
        console.error("Failed to fetch user data", error);
      });
  };

  return (
    <div>
      <FunctionalityNavbar />
      <div className="container">
        <form onSubmit={HandleSubmit} className="comic-form">
          <label htmlFor="split">
            <input
              type="radio"
              id="split"
              value="SPLIT"
              name="anserw"
              onChange={handleChange}
            />
            SPLIT 
          </label>

          <label htmlFor="fbw">
            <input
              type="radio"
              id="fbw"
              value="FBW"
              name="anserw"
              onChange={handleChange}
            />
            FBW 
          </label>

          <label htmlFor="pushpull">
            <input
              type="radio"
              id="pushpull"
              value="PUSHPULL"
              name="anserw"
              onChange={handleChange}
            />
            PUSH-PULL 
          </label>
          <label>Diet description</label>
                    <input
        type="text"
        value={description}
        onChange={handleInput}
      />
          <input className="submit-button" type="submit" value="Submit" />
        
        </form>
        <div className="user-data">
          {userData ? (
            userData.map((item, index) => (
              <div key={index}>

                <CustomExcercises onreplace={replaceData} data={item} />
              </div>
            ))
          ) : (
            <p className="warning">Select a training type</p>
          )}
        </div>

        <div className="save-button">
          {userData ? (
            <div>
              <Button variant="contained" onClick={saveTrainig}>
                Save
              </Button>
            </div>
          ) : (
            <p></p>
          )}
        </div>
      </div>
    </div>
  );
};

export default TrainingCustomization;