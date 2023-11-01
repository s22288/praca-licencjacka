import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import "../../../../context/customization.css";
import Button from "@mui/material/Button";
import CustomExcercises from "./exercise/exerciseCustom";
import FunctionalityNavbar from "../../../Medium/navbar/functionalitynavbar";
import { GetExerciseseByBodyPartFbw, GetExerciseseByBodyPartSplit, GetExerciseseByBodyPartPushPull, SaveTrainig } from "../../../../services/trainingServices/trainingService";
import FbwTraining from "./fbw/fbwTraining";
import { Splide, SplideSlide } from "@splidejs/react-splide";
import SplitTraining from "./split/splitTraining";
const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState('SPLIT');
  const [userData, setUserData] = useState();
  const [userDataSplit, setUserDataSplit] = useState();

  const navigate = useNavigate();
  const [description, setDescription] = useState('trainin desc');
  const contentArray = new Array(3).fill(null);

  const saveTrainig = (event) => {

    event.preventDefault();
    let toSave = []
    if (excercise === "FBW") {
      toSave = userData.map((data) => data.exerciseEntity);

    } if (excercise === "SPLIT") {
      toSave = Object.values(userDataSplit).flat().map(value => value.exerciseEntity)
      // for (const day of ["one", "two", "three"]) {
      //   for (const entry of userDataSplit[day]) {
      //     toSave.push(entry.exerciseEntity);
      //   }
      // }

    }
    const trainingToSave = {
      description: description,
      maxAge: 99,
      treiningType: excercise,
      exerciseEntitySet: toSave,
    };

    SaveTrainig(trainingToSave);
    navigate("/user-page");
  };
  const handleInput = (event) => {
    setDescription(event.target.value);
  };
  const HandleSubmit = (event) => {
    event.preventDefault();

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

    if (excercise === 'FBW') {


      GetExerciseseByBodyPartFbw()
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
    }




    if (excercise === 'SPLIT') {
      GetExerciseseByBodyPartSplit()
        .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Failed to fetch user data");
          }
        })
        .then((data) => {
          setUserDataSplit(data);



        })
        .catch((error) => {
          console.error("Failed to fetch user data", error);
        });
    }
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





          {excercise == 'FBW' && userData ? (

            <FbwTraining data={userData} />
          ) : (
            <p className="context-customize-warning"></p>
          )}


          {excercise == 'SPLIT' && userDataSplit ? (

            <SplitTraining data={userDataSplit} />
          ) : (
            <p className="context-customize-warning"></p>
          )}
        </div>



        <div >
          {userData || userDataSplit ? (
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