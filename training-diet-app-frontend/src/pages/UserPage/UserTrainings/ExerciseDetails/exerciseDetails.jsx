import { useLocation } from "react-router-dom";
import CustomizedRating from "../ExerciseDetails/customRaiting";
import trainImage from "../../../../assets/traininguser.jpg";
import FunctionalityNavbar from "../../../../components/Medium/navbar/functionalitynavbar";
import './../../../../context/mealsandexercisedetails.css'
import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";

const ExcerciseDetails = () => {
    const location = useLocation();
    const data = location.state?.data;


    if (!data) {
        return <div>No exercise data available.</div>;
    }

    console.log(data)
    
    return (
        <div>
            <FunctionalityNavbar />
            <div >
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
            <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Day 1</TableCell>
            <TableCell align="right">Day 2</TableCell>
            <TableCell align="right">Day 3</TableCell>

          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.name}
              </TableCell>
              <TableCell align="right">{row.calories}</TableCell>
              <TableCell align="right">{row.fat}</TableCell>
              <TableCell align="right">{row.carbs}</TableCell>
              <TableCell align="right">{row.protein}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
        </div>
    );
};
export default ExcerciseDetails;