import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import "./custom.css"; // Import your custom CSS file for styling

const CustomMeal = (props) => {
    let exer = props.data;
    let main = props.data.mealEntity;

    const handleHange = (altIndex) => {
        let mainId = main.id;
        props.onreplace(altIndex, mainId);
    };

    if (!main) {
        return null;
    }

    return (
        <div className="meal-container">
            <div className="left">
                <h4>Meal:</h4>
                <Card sx={{ maxWidth: 345 }}>
                    <CardActionArea>
                        <CardMedia
                            component="img"
                            height="140"
                            image="https://img.freepik.com/premium-vector/healthy-food-hand-symbol-cartoon-illustration-vector_201904-1555.jpg?w=2000"
                            alt="green iguana"
                        />
                        <CardContent>
                           
                            <Typography gutterBottom variant="h5" component="div">
                                {main.mealName}
                            </Typography>

                            <Typography variant="h6" color="text.secondary">
                                Calories {main.calories}
                            </Typography>
                            <Typography variant="h6" color="text.secondary">
                                {main.mealTypeId}
                            </Typography>
                        </CardContent>
                    </CardActionArea>
                </Card>
            </div>
            <div className="right">
                <h4>Alternatives:</h4>
                <div className="alternatives-row">
                    {exer.alternatives &&
                        exer.alternatives.map((alt, idx) => (
                            <div className="altern" key={idx}>
                                <Card sx={{ maxWidth: 345, backgroundColor: "ActiveBorder" }}>
                                    <CardActionArea>
                                        <CardMedia
                                            component="img"
                                            height="140"
                                            image="https://img.freepik.com/premium-vector/healthy-food-hand-symbol-cartoon-illustration-vector_201904-1555.jpg?w=2000"
                                            alt="green iguana"
                                        />

                                        <CardContent>
                                          
                                            <Typography
                                                gutterBottom
                                                variant="h5"
                                                color="white"
                                                component="div"
                                            >
                                                {alt && alt.mealName}
                                            </Typography>

                                            <Typography variant="h6" color="white">
                                                {alt && `Calories ${alt.calories}`}
                                            </Typography>
                                            <Typography variant="h6" color="white">
                                                {alt && alt.mealTypeId}
                                            </Typography>
                                        </CardContent>
                                    </CardActionArea>
                                    <CardActions>
                                        <Button
                                            onClick={() => handleHange(idx, alt.id)}
                                            variant="contained"
                                        >
                                            Change
                                        </Button>
                                    </CardActions>
                                </Card>
                            </div>
                        ))}
                </div>
            </div>
        </div>
    );
};

export default CustomMeal;
