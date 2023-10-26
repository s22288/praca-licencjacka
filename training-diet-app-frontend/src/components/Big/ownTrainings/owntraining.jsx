import { useState, useEffect } from "react";
import "../../../context/own.css";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActions } from "@mui/material";
import { Link } from "react-router-dom";
import { DelteteTrainigById, GetAllTrainings } from "../../../services/trainingServices/trainingService";
import photo from '../../../assets/traininguser.jpg'
import TrainingDetails from "./trainingDetails";

const OwnTrainings = () => {
    const [userData, setUserData] = useState(null);
    const [loading, setLoading] = useState(true);

    const handleNoteDeletion = (id) => {
        setUserData((prevUserData) =>
            prevUserData.filter((item) => item.id !== id)
        );
    };
    useEffect(() => {


        GetAllTrainings()
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Failed to fetch user data");
                }
            })
            .then((data) => {
                setUserData(data);
                setLoading(false);
                console.log(data);
            })
            .catch((error) => {
                console.error("Failed to fetch user data", error);
                setLoading(false);
            });

    }, []);
    return (
        <div className="onwTraningContainer">
            {loading ? (
                <p>Loading...</p>
            ) : userData && userData.length > 0 ? (
                <div className="own-elo">
                    {userData.map((item) => (
                        <TrainingDetails className="emptytrain"
                            key={item.id}
                            val={item}
                            ondelete={handleNoteDeletion}
                        />
                    ))}
                </div>
            ) : (
                <p className="emptytrain">No Training available</p>
            )}
        </div>
    );
};
export default OwnTrainings;