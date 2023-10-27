import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import "../../../../context/customization.css";
import Button from "@mui/material/Button";
import CustomExcercises from "./exercise/exerciseCustom";
import FunctionalityNavbar from "../../../Medium/navbar/functionalitynavbar";
import { GetExerciseseByBodyPart, SaveTrainig } from "../../../../services/trainingServices/trainingService";
import FbwTraining from "./fbw/fbwTraining";
import { Splide, SplideSlide } from "@splidejs/react-splide";
const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState('SPLIT');
  const [userData, setUserData] = useState();
  const navigate = useNavigate();
  const [description, setDescription] = useState('trainin desc');
  const contentArray = new Array(3).fill(null);

  const saveTrainig = (event) => {

    event.preventDefault();
    let exercises = userData.map((data) => data.exerciseEntity);

    const trainingToSave = {
      description: description,
      maxAge: 99,
      treiningType: excercise,
      exerciseEntitySet: exercises,
    };

    SaveTrainig(trainingToSave);
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

    GetExerciseseByBodyPart()
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
      <div className="context-customize-container">
        <form onSubmit={HandleSubmit} className="context-customize-comic-form">
          <label htmlFor="split">
            <input
              type="radio"
              id="split"
              value="SPLIT"
              name="anserw"
              onChange={handleChange}
              defaultChecked

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
          <label>Training description</label>
          <input className="context-customize-inputdesc"
            type="text"
            value={description}
            onChange={handleInput} required
          />
          <br />
          <br></br>
          <input className="context-customize-submit-button" type="submit" value="Submit" />

        </form>

        <div className="user-data">
          <Splide aria-label="My Favorite Images">

            {excercise == 'FBW' && userData && contentArray.map((_, index) => (
              <SplideSlide>

                <div key={index}>
                  <h2 className="context-day-data">day {index + 1}</h2>
                  {excercise == 'FBW' && userData ? (
                    <FbwTraining data={userData} />
                  ) : (
                    <p className="context-customize-warning">Select a training type</p>
                  )}
                </div>
              </SplideSlide>
            ))}
          </Splide>
          {/* {userData ? (
            userData.map((item, index) => (
              <div key={index}>

                <CustomExcercises onreplace={replaceData} data={item} />
              </div>
            ))
          ) : (
            <p className="context-customize-warning">Select a training type</p>
          )} */}
        </div>

        <div >
          {userData ? (
            <div >
              <Button variant="contained" onClick={saveTrainig}>
                Save
              </Button>
            </div>
          ) : (
            <p></p>
          )}
        </div>
      </div>
    </div >
  );
};

export default TrainingCustomization;