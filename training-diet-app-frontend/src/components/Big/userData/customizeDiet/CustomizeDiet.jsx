import { useEffect, useState } from "react";

import { Button } from "@mui/material";
import "../../../../context/customization.css";
import {
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
    const [description, setDescription] = useState('describe diet');
    const [alergic, setAlergic] = useState([]);
    const [options, setOptions] = useState([]);
    const [selectedOption, setSelectOption] = useState(1);
    const [goal, setGoal] = useState('lose')

    const [calories, setCalories] = useState()

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



        // setAlergics(userData);
    };


    const calculateCalories = () => {
        let count = userData.map((data) => data.mealEntity.calories).reduce((start, next) => start + next, 0);

        setCalories(count)
        return count;
    }

    const ToMainMeals = () => {
        return userData.map((data) => data.mealEntity)
    }
    const saveDiet = (event) => {
        event.preventDefault();



        const dietData = {
            caloriesCount: calculateCalories(),
            dietName: description,
            dietGoal: goal,
            mealEntitySet: ToMainMeals(),
        };
        SaveDiet(dietData);
        navigate("/user-page/create-training/train-customize");
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

    const passGoalToParent = (record) => {
        setGoal(record)
    }
    return (
        <div>
            <FunctionalityNavbar />

            <div className="context-customize-container">
                <SelectDietGoal passGoalToParent={passGoalToParent} />


                <form onSubmit={HandleSubmit} className="context-customize-comic-form">
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
                        onChange={handleInput} required
                    />
                    <br />
                    <br></br>

                    <input type="submit" value="Submit" className="context-customize-submit-button" />
                </form>


            </div>
            <div className="context-customize-user-data">
                {userData ? (
                    userData.map((item, index) => (
                        <div key={index}>
                            <CustomMeal onreplace={replaceData} data={item} />
                        </div>
                    ))
                ) : (
                    <p className="context-customize-warning">Select a Diet type</p>
                )}
                <div className="context-customize-save-button">

                    {userData ? (
                        <div>
                            <Button variant="contained" onClick={saveDiet}>
                                Save
                            </Button>
                        </div>

                    ) : (<p></p>)}
                </div>
            </div>

            <div className="context-customize-save-button">
                {userData ? (
                    <div>
                        <p className="calories">
                            Alergeny:
                            {alergic.map((a, index) => (
                                <div key={index} className="context-customize-comic-div">
                                    <p className="context-customize-alergic"> {a}</p>
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