import { useEffect, useState } from 'react'
import './calendar.css'
import { AsignTrainingToDay, GetAllTrainings, GetAllTrainingsWithDays } from '../../../../services/trainingServices/trainingService'
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";

const CalendarOfTraining = () =>{
const [data,setData] = useState();
const [day,setDay] =useState()
const [training,setTraining] =useState()
const [description,setDescription] = useState('desc');
const[localization,setLocalization] = useState('loc')
const [datawithDays,setDataWithDays] = useState()
useEffect(()=>{
    GetAllTrainingsWithDays().then((response) => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error("Failed to fetch user data");
        }
    })
    .then((data) => {
        setDataWithDays(data);
        console.log(data)
        
    })
    .catch((error) => {
        console.error("Failed to fetch user data", error);
    });


},[])
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
    const chooseDay = (event)=>{
setDay(event.currentTarget.value)
    }
    const handleAsign=(event)=>{
        setTraining(event.currentTarget.value)
    }
    const handleInput=(event)=>{
        
setDescription(event.currentTarget.value)
    }
    const handleInputloc = (event) =>{
        setLocalization(event.currentTarget.value)
    }
    const HandleSubmit = (event) =>{
        event.preventDefault();
        console.log('id '  + training.id)
        const eventTraining = {
            description: description,
            localozation: localization,
            day: day,
          };
          
          const idTraining = 1;
          
         
         
        AsignTrainingToDay(eventTraining,idTraining).then((response) => {
            if (response.ok) {
              return response.json();
            } else {
              throw new Error("Failed to fetch user data");
            }
          })
          .then((data) => {
    
    
           
          })
          .catch((error) => {
            console.error("Failed to fetch user data", error);
          })
    }
    return(
        <div>
            
            <div>
           
            </div>
        <div className="calendar-days-container">
            <div id="mon" className="calendar-day">
             <button value={'mon'} onClick={chooseDay}>Monday</button>   
            </div>
            <div id="tue" className="calendar-day">
             <button  value={'tue'} onClick={chooseDay}>Tuesday</button>   
            </div>
            <div id="wen" className="calendar-day">
          <button value={'wen'} onClick={chooseDay}>Wendsday</button>      
            </div>
            <div id="thu" className="calendar-day">
             <button value={'thu'} onClick={chooseDay}>Thursday</button>   
            </div>
            <div id="fri" className="calendar-day">
           <button value={'fri'} onClick={chooseDay}>Friday</button>     
            </div>
            <div id="sat" className="calendar-day">
            <button value={'sat'} onClick={chooseDay}>Saturday</button>     
            </div>
            <div id="sun" className="calendar-day">
            <button value={'sun'} onClick={chooseDay}>Sunday</button>     
  
            </div>

           
            </div>
            <h2>treningi</h2>

            {data ? (
            data.map((item, index) => (
              <div  key={index}>
              
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
                    <button value={item} onClick={handleAsign} className="">
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

        <form onSubmit={HandleSubmit} className="calendar-day-form">

             <label>Diet description</label>
                    <input
        type="text"
        value={description}
        onChange={handleInput}
        required    />

<label>Lokalizacja</label>
                    <input
        type="text"
        value={localization}
        onChange={handleInputloc}
    required  />

<input className="submit-button" type="submit" value="Submit" />
        
        </form>
        </div>
    )
}

export default CalendarOfTraining