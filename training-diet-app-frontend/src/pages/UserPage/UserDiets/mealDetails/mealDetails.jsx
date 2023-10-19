import { useLocation } from "react-router-dom";
import trainImage from "../../../../assets/food.jpeg"
import FunctionalityNavbar from "../../../../components/Medium/navbar/functionalitynavbar";
import { useEffect } from "react";

const MealDetails = () => {
    const location = useLocation();
    console.log('Location:', location);
    const data = location.state?.data;
    
    console.log('Data:', data);
    if (!data) {
        return <div>
            <FunctionalityNavbar />
            <p>No Dishes data available.</p></div>;
    }

    return (
        <div>
            <FunctionalityNavbar />

            <div className="alignCenter">

                <div className="exercise-details-container">
                    {data.map((dish) => (
                        <div className="exercise-card" key={dish.id}>
                            <img src={trainImage} alt={dish.mealName} />
                            <div className="exercise-details">
                                <h3>{dish.mealName}</h3>
                                <p className="customText">Calories {dish.calories}</p>
                                <p className="customText"> {dish.mealTypeId}</p>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};
export default MealDetails;