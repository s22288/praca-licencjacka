import { useEffect, useState } from "react";

import { Button } from "@mui/material";
import "./customization.css";

import {
    CountCalories,
    GetAllMealTypes,
    SaveDiet,
} from "../../../../services/dietServices/dietService"
import { useNavigate } from "react-router-dom";

import FunctionalityNavbar from "../../../Medium/navbar/functionalitynavbar";
import CustomMeal from "./customMeal/customMeal";
import { GetMealByMealType } from "../../../../services/mealService/mealService";
import SelectDietGoal from "./SelectInput";
const DietCustomization = () => {

    const navigate = useNavigate();
    const [userData, setUserData] = useState();
const [description,setDescription] = useState('describe diet');
    const [alergic, setAlergic] = useState([]);
    const [options, setOptions] = useState([]);
    const [selectedOption, setSelectOption] = useState();
    const [goal,setGoal]=useState('lose')

    const [calories,setCalories] =useState ()

    useEffect(() => {
        GetAllMealTypes().then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Failed to fetch user data");
            }
        })
            .then((data) => {
                setOptions(data)
                console.log(data)
                calculateCalories()
            })
            .catch((error) => {
                console.error("Failed to fetch user data", error);
            });
    }, [])
    const HandleSubmit = (event) => {
        event.preventDefault();

        fetchUserData(selectedOption);


    };
    const handleChange = (event) => {
        event.preventDefault();

        setSelectOption(event.target.value);
    };


    const setAlergics = (all) => {
        let ing = [];
        all.forEach((a) => {
            let element = a.mealEntity.ingridient;
            ing.push(element);
        });
        let names = ing.map((i) => i.name);
        let uniqueNames = Array.from(new Set(names));

        setAlergic(uniqueNames);
    };
    const replaceData = (index, mainIndex) => {
        console.log('index ' + index)
        console.log('main ' + mainIndex)

        let userDataIndex = userData.findIndex((d) => {
            return d.mealEntity.id === mainIndex;
        });


        const updatedUserData = [...userData];
        const alternatives = updatedUserData[userDataIndex].alternatives;
        if (alternatives.length > 0) {
            let copy = updatedUserData[userDataIndex].mealEntity;
            updatedUserData[userDataIndex].mealEntity = alternatives[index];
            updatedUserData[userDataIndex].alternatives[index] = copy;
        }
        setUserData(updatedUserData);
       
     calculateCalories();

        // setAlergics(userData);
    };


    const calculateCalories = () => {
      let count =   userData.map((data) => data.mealEntity.calories).reduce((start, next) => start + next, 0);
      console.log(count)
         setCalories(count)
    }
    
    const ToMainMeals =()=>{
        return userData.map((data)=> data.mealEntity)
    }
    const saveDiet = (event) => {
        event.preventDefault();
        console.log(userData);
    
        const dietData = {
            caloriesCount: calories,
            dietName: description,
            dietGoal: goal,
            mealEntitySet: ToMainMeals(),
        };
        SaveDiet(dietData);
        navigate("/user-page");
    };
    

    const fetchUserData = (typeId) => {

        GetMealByMealType(typeId)
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
    const handleInput = (event) => {
        setDescription(event.target.value);
      };
    
      const passGoalToParent=(record)=>{
        setGoal(record)
    }
    return (
        <div>
            <FunctionalityNavbar />

            <div className="container">
                <SelectDietGoal passGoalToParent={passGoalToParent}  />


                <form onSubmit={HandleSubmit} className="comic-form">
                    {options.map(option => (
                        <label key={option.id}>
                            <input
                                type="radio"
                                value={option.id}
                                name="return"
                                checked={selectedOption == option.id}

                                onChange={handleChange}
                            />
                            {option.name}
                        </label>
                    ))}
                    <label>Diet description</label>
                    <input
        type="text"
        value={description}
        onChange={handleInput}
      />
      <br />
                    <br></br>

                    <input type="submit" value="Submit" className="submit-button" />
                </form>


            </div>
            <div className="user-data">
                {userData ? (
                    userData.map((item, index) => (
                        <div key={index}>
                            <CustomMeal onreplace={replaceData} data={item} />
                        </div>
                    ))
                ) : (
                    <p className="warning">Select Diet type</p>
                )}
                {userData ? (
                    <Button variant="contained" onClick={saveDiet}>
                        Save
                    </Button>
                ) : (<p></p>)}
            </div>

            <div className="save-button">
                {userData ? (
                    <div>
                        <p className="calories">
                                Alergeny:
                                {alergic.map((a, index) => (
                                    <div key={index} className="comic-div">
                                        <p className="alergic"> {a}</p>
                                    </div>
                                ))}
                            </p>

                    </div>
                ) : (
                    <p></p>
                )}
            </div>
        </div>
    );
};
export default DietCustomization;