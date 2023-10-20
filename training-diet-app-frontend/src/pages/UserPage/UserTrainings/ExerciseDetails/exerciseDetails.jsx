import { useLocation } from "react-router-dom";
import "./exercise.css";
import CustomizedRating from "../ExerciseDetails/customRaiting";
import trainImage from "../../../../assets/traininguser.jpg";
import FunctionalityNavbar from "../../../../components/Medium/navbar/functionalitynavbar";

const ExcerciseDetails = () => {
    const location = useLocation();
    const data = location.state?.data;

    if (!data) {
        return <div>No exercise data available.</div>;
    }

    return (
        <div>
            <FunctionalityNavbar />
            <div className="alignCenter">
                <div className="exercise-details-container">
                    {data.map((exercise) => (
                        <div className="exercise-card" key={exercise.id}>
                            <img src={trainImage} alt={exercise.name} />
                            <div className="exercise-details">
                                <h3>{exercise.name}</h3>
                                <CustomizedRating rate={exercise.levelOfAdvance} />
                                <p className="customText">Reps {exercise.reps}</p>
                                <p className="customText">Series {exercise.series}</p>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};
export default ExcerciseDetails;