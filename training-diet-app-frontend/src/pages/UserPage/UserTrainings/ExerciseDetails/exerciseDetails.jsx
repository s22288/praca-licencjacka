import { useLocation } from "react-router-dom";
import CustomizedRating from "../ExerciseDetails/customRaiting";
import trainImage from "../../../../assets/traininguser.jpg";
import FunctionalityNavbar from "../../../../components/Medium/navbar/functionalitynavbar";
import './../../../../context/mealsandexercisedetails.css'

const ExcerciseDetails = () => {
    const location = useLocation();
    const data = location.state?.data;
console.log(data)

    if (!data) {
        return <div>No exercise data available.</div>;
    }




  
      return(
        <div>
<FunctionalityNavbar/>
<div className="context-details-container">
{data.map((exercise) => (
            <div className="context-card" key={exercise.id}>
                          <img src={trainImage} alt={exercise.name} />

                          <div className="exercise-details">
                              <h3>Name: {exercise.name}</h3>
                              <p>BodyPart:  {exercise.bodypartEntitySet[0].description}</p>
                              <CustomizedRating rate={exercise.levelOfAdvance} />
                              <p >Reps {exercise.reps}</p>
                              <p >Series {exercise.series}</p>
                          </div>
</div>
))}
  
</div>
</div>
   
    );
};
export default ExcerciseDetails;