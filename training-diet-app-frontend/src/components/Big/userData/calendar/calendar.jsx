import { useEffect, useState } from 'react'
import './calendar.css'
import { GetAllTrainings } from '../../../../services/trainingServices/trainingService'
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";

const CalendarOfTraining = () =>{
const [data,setData] = useState();
const [day,setDay] =useState()
const [training,setTraining] =useState()

    useEffect(()=>{
        GetAllTrainings().then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Failed to fetch user data");
            }
        })
        .then((data) => {
            setData(data);
            console.log(data)
            
        })
        .catch((error) => {
            console.error("Failed to fetch user data", error);
        });

    },[])
    const handleAsign=(event)=>{
        console.log(event.currentTarget.id);
        setTraining()
    }
    return(
        <div>
            
            <div>
           
            </div>
        <div className="calendar-days-container">
            <div id="mon" className="calendar-day">
             <button>Monday</button>   
            </div>
            <div id="tue" className="calendar-day">
             <button>Tuesday</button>   
            </div>
            <div id="wen" className="calendar-day">
          <button>Wendsday</button>      
            </div>
            <div id="thu" className="calendar-day">
             <button>Thursday</button>   
            </div>
            <div id="fri" className="calendar-day">
           <button>Friday</button>     
            </div>
            <div id="sat" className="calendar-day">
            <button>Saturday</button>     
            </div>
            <div id="sun" className="calendar-day">
            <button>Sunday</button>     
  
            </div>

           
            </div>
            <h2>treningi</h2>
            {data ? (
            data.map((item, index) => (
              <div key={index}>
              
                  <Card sx={{ maxWidth: 345 }}>
                <CardMedia sx={{ height: 140 }} image={'https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg'} title="green iguana" />
                <CardContent>
                   
                    <Typography variant="h6" color="text.secondary">
                      Opis:  {item.description}
                    </Typography>
                    <Typography variant="body1" color="text.secondary">
                       Type: {item.treiningType}
                    </Typography>
                    <Typography variant="body1" color="text.secondary">
                      Max age:   {item.maxAge}
                    </Typography>
                </CardContent>
                <CardActions>
                    <button onClick={handleAsign} className="">
                        Assign
                    </button>
                    
                </CardActions>
            </Card>
            
              </div>
              
            )
            
            )
            
          
          )
           : (
            <p className="warning">Select a training type</p>
          )}
           
        </div>
    )
}

export default CalendarOfTraining