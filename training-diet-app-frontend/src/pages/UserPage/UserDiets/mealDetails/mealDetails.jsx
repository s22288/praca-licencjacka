import { useLocation } from "react-router-dom";
import trainImage from "../../../../assets/food.jpeg"
import FunctionalityNavbar from "../../../../components/Medium/navbar/functionalitynavbar";
import './../../../../context/mealsandexercisedetails.css'
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

            <div >

                <div className="context-details-container">
                    {data.map((dish) => (
                        <div className="context-card" key={dish.id}>
                            <img src={trainImage} alt={dish.mealName} />
                            <div className="exercise-details">
                                <h3> name: {dish.mealName}</h3>
                                <p className="context-customText">Calories {dish.calories} kcal</p>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};
export default MealDetails;