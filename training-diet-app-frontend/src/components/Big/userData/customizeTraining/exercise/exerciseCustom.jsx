import "./custom.css";

import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import CustomizedRating from '../../../../../pages/UserPage/UserTrainings/ExerciseDetails/customRaiting'

const CustomExcercises = (props) => {

  let exer = props.data;


  let main = props.data.exerciseEntity;

  const id = main.id;
  const handleHange = (altIndex) => {
    let mainId = id
    props.onreplace(altIndex, mainId);
  };
  if (!main) {
    return null;
  }
  return (
    <div id="parent">

      <div className="exercise-left">

        <Card sx={{ maxWidth: 600, backgroundColor: 'gold' }}>
          <CardActionArea>
            <div style={{ display: 'flex' }}>
              <CardMedia
                component="img"
                style={{ height: "140px", width: "150px" }}
                image={main.bodypartEntitySet[0].url}
              />
              <CardMedia
                component="img"
                height="140"
                image="https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg"
                alt="green iguana"
              />

            </div>
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Exercise: {main.name}
              </Typography>
              <Typography>
                <CustomizedRating rate={main.levelOfAdvance} />
              </Typography>
              <Typography variant="h6" color="text.secondary">
                Body Part:   {main.bodypartEntitySet[0].description}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                Series: {main.series}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                Reps {main.reps}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                {main.trainingType}
              </Typography>






            </CardContent>
          </CardActionArea>
        </Card>
      </div>

      <div className="exercise-right">
        <div className="exercise-alternatives-row">
          {exer.alternatives.map((alternative, idx) => (
            <div className="exercise-altern" key={idx}>
              <Card sx={{ maxWidth: 600 }}>
                <CardActionArea>

                  <CardMedia
                    component="img"
                    height="140"
                    image="https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg"
                    alt="green iguana"
                  />

                  <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                      Exercise: {alternative.name}
                    </Typography>
                    <Typography>
                      <CustomizedRating rate={alternative.levelOfAdvance} />
                    </Typography>
                    <Typography variant="h6" color="text.secondary">
                      Body Part:   {alternative.bodypartEntitySet[0].description}
                    </Typography>
                    <Typography variant="h6" color="text.secondary">
                      Series: {alternative.series}
                    </Typography>
                    <Typography variant="h6" color="text.secondary">
                      Reps {alternative.reps}
                    </Typography>
                    <Typography variant="h6" color="text.secondary">
                      {alternative.trainingType}

                    </Typography>


                    <CardActions>
                      <Button
                        onClick={() => handleHange(idx, alternative.id)}
                        variant="contained"
                      >
                        Change
                      </Button>
                    </CardActions>


                  </CardContent>
                </CardActionArea>
              </Card>
            </div>
          ))}
        </div>

      </div>
    </div>
  );
};
export default CustomExcercises;