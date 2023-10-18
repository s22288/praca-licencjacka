import { useState } from "react";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";
import { Link } from "react-router-dom";

import "../ownTrainings/details.css"
import { DelteteMealbyId } from "../../../services/mealService/mealService";
const DietDetails = (props) => {
    const [isDeleted, setIsDeleted] = useState(false);
   
    const {  mealEntityList } = props.val;
const {id, dietName, caloriesCount, dietGoal,} = props.val.dietEntity;
    const handleDelelte = () => {

        DelteteMealbyId(id)
            .then((response) => {
                if (response.ok) {
                    props.ondelete(id);
                    setIsDeleted(true);
                } else {
                    console.log("Failed to delete note");
                }
            })
            .catch((error) => {
                console.error("Error deleting note:", error);
            });

    };
    if (isDeleted) {
        return null;
    }

    return (
        <div>
            <Card sx={{ maxWidth: 345 }}>
                <CardMedia sx={{ height: 140 }} image={'data:image/jpeg;base64,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'} title="green iguana" />
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        {dietName} {caloriesCount} kcal
                    </Typography>
                    <Typography variant="body1" color="text.secondary">
                        {dietGoal}
                    </Typography>
                </CardContent>
                <CardActions>
                    <button onClick={handleDelelte} className="delte-perfect">
                        Delete
                    </button>
                    <Link
                        className="link-perfect"
                        to={`/user-page/diet/details/${id}`}
                        state={{ data: mealEntityList }}
                    >
                        Details
                    </Link>
                </CardActions>
            </Card>
        </div>
    );
};
export default DietDetails;