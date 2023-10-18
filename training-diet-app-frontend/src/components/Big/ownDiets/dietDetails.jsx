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

    const { id, dietName , caloriesCount, dietGoal, dishesList } = props.val;

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
                <CardMedia sx={{ height: 140 }} image={''} title="green iguana" />
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
                        state={{ data: dishesList }}
                    >
                        Details
                    </Link>
                </CardActions>
            </Card>
        </div>
    );
};
export default DietDetails;