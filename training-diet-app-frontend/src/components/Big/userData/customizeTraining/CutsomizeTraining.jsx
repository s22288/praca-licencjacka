import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./customization.css";
import Button from "@mui/material/Button";
import backgroundSVG from "../../../../assets/wave.svg"
import CustomExcercises from "./exercise/exerciseCustom";
import FunctionalityNavbar from "../../../Medium/navbar/functionalitynavbar";
import { GetExerciseseByTrainingType, SaveTrainig } from "../../../../services/trainingServices/trainingService";
const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState("");
  const [userData, setUserData] = useState();
  const navigate = useNavigate();
  const [trainingType, setTrainingType] = useState("");

  const saveTrainig = (event) => {
    event.preventDefault();
    let exercices = userData.map((data) => data.excercise);
    const trainingToSave = {
      name: trainingType,
      maxAge: 99,
      excercieses: exercices,
    };
   
    SaveTrainig( trainingToSave);
    navigate("/user-page");
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
      return d.excercise.id === mainIndex;
    });
    const updatedUserData = [...userData];
    const alternatives = updatedUserData[userDataIndex].alternatives;
    if (alternatives.length > 0) {
      let copy = updatedUserData[userDataIndex].excercise;
      updatedUserData[userDataIndex].excercise = alternatives[index];
      updatedUserData[userDataIndex].alternatives[index] = copy;
    }
    setUserData(updatedUserData);
  };
  const fetchUserData = (type) => {

    GetExerciseseByTrainingType( type)
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