import { useEffect, useState } from 'react'
import './calendar.css'
import { AsignTrainingToDay, GetAllTrainings, GetAllTrainingsWithDays } from '../../../../services/trainingServices/trainingService'
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActions } from "@mui/material";
import SmallTraining from '../../ownTrainings/smallTraining';
import { Splide, SplideSlide } from '@splidejs/react-splide';
import '@splidejs/splide/dist/css/splide.min.css'; // Import Splide CSS
import { AlignHorizontalCenter } from '@mui/icons-material';

const CalendarOfTraining = () => {

    const [data, setData] = useState([]);
    const [week, setWeek] = useState('mon')
    const [training, setTraining] = useState()
    const [description, setDescription] = useState('desc');
    const [localization, setLocalization] = useState('loc')
    const [mondayTrainings, setMondayTrainings] = useState([])
    const [tuesdayTrainings, setTuesdayTrainings] = useState([])
    const [wendsdayTrainings, setWendsdayTrainings] = useState([])
    const [thursdayTrainings, setThursdayTrainings] = useState([])
    const [fridayTrainings, setFridayTrainings] = useState([])
    const [saturdayTrainings, setSaturdayTrainings] = useState([])
    const [sundayTrainings, setSundayTrainings] = useState([])

    function addToCalendar() {
        GetAllTrainingsWithDays().then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Failed to fetch user data");
            }
        })
            .then((data) => {
                console.log('data' + data)
                setData(data)
                setMondayTrainings(data.filter((d) => d.day.day === 'mon'));
                setTuesdayTrainings(data.filter((d) => d.day.day === 'tue'));
                setWendsdayTrainings(data.filter((d) => d.day.day === 'wen'));
                setThursdayTrainings(data.filter((d) => d.day.day === 'thu'));
                setFridayTrainings(data.filter((d) => d.day.day === 'fri'));
                setSaturdayTrainings(data.filter((d) => d.day.day === 'sat'));
                setSundayTrainings(data.filter((d) => d.day.day === 'sun'));
                console.log(wendsdayTrainings)
            })
            .catch((error) => {
                console.error("Failed to fetch user data", error);
            });

    }

    useEffect(() => {
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
        addToCalendar()

    }, [])
    const chooseDay = (event) => {
        event.preventDefault();

        setWeek(event.currentTarget.value)

    }
    const handleAsign = (event) => {
        event.preventDefault();


        setTraining(event.currentTarget.value)
    }
    const handleInput = (event) => {

        setDescription(event.currentTarget.value)
    }
    const handleInputloc = (event) => {
        setLocalization(event.currentTarget.value)
    }
    const HandleSubmit = (event) => {
        event.preventDefault();

        const eventTraining = {
            description: description,
            localozation: localization,
            week: week,
        };

        console.log(eventTraining, training)



        AsignTrainingToDay(eventTraining, training)
        addToCalendar()
    }
    return (
        <div>

            <div>

            </div>
            <div className="calendar-days-container">

                <div id="mon" className="calendar-day">
                    <button value={'mon'} onClick={chooseDay}>WEEK I</button>
                    <div>
                        <Splide aria-label="My Favorite Images">
                            {mondayTrainings && mondayTrainings.map((item, index) => (

                                <SplideSlide key={index}>
                                    <SmallTraining key={item.id} val={item} />

                                </SplideSlide>


                            ))}
                        </Splide>

                    </div>
                </div>
                <div id="tue" className="calendar-day">
                    <button value={'tue'} onClick={chooseDay}>WEEK II</button>
                    <div>
                        <Splide aria-label="My Favorite Images">

                            {tuesdayTrainings && tuesdayTrainings.map((item, index) => (
                                <SplideSlide key={index}>
                                    <SmallTraining className="calendar-emptytrain"
                                        key={item.trainingEntity.id}
                                        val={item}
                                    />
                                </SplideSlide>
                            ))}
                        </Splide>

                    </div>
                </div>
                <div id="wen" className="calendar-day">
                    <button value={'wen'} onClick={chooseDay}>WEEK III</button>
                    <div>
                        <Splide aria-label="My Favorite Images">
                            {wendsdayTrainings && wendsdayTrainings.map((item, index) => (
                                <SplideSlide key={index}>

                                    <SmallTraining className="calendar-emptytrain" key={item.trainingEntity.id} val={item} />
                                </SplideSlide>

                            ))}
                        </Splide>
                    </div>
                </div>
                <div id="thu" className="calendar-day">
                    <button value={'thu'} onClick={chooseDay}>WEEK IV</button>
                    <Splide aria-label="My Favorite Images">
                        {thursdayTrainings && thursdayTrainings.map(item => (
                            <SplideSlide>

                                <SmallTraining className="calendar-emptytrain" key={item.trainingEntity.id} val={item} />
                            </SplideSlide>

                        ))}
                    </Splide>
                </div>
                <div id="fri" className="calendar-day">
                    <button value={'fri'} onClick={chooseDay}>WEEK V</button>
                    <Splide aria-label="My Favorite Images">
                        {fridayTrainings && fridayTrainings.map(item => (
                            <SplideSlide>

                                <SmallTraining className="calendar-emptytrain" key={item.trainingEntity.id} val={item} />
                            </SplideSlide>

                        ))}
                    </Splide>
                </div>
                <div id="sat" className="calendar-day">
                    <button value={'sat'} onClick={chooseDay}>WEEK VI</button>
                    <Splide aria-label="My Favorite Images">
                        {saturdayTrainings && saturdayTrainings.map(item => (
                            <SplideSlide>

                                <SmallTraining className="calendar-emptytrain" key={item.trainingEntity.id} val={item} />
                            </SplideSlide>

                        ))}
                    </Splide>
                </div>
                <div id="sun" className="calendar-day">
                    <button value={'sun'} onClick={chooseDay}>WEEK VII</button>
                    <Splide aria-label="My Favorite Images">
                        {sundayTrainings && sundayTrainings.map(item => (
                            <SplideSlide>

                                <SmallTraining className="calendar-emptytrain" key={item.trainingEntity.id} val={item} />
                            </SplideSlide>

                        ))}
                    </Splide>
                </div>


            </div>

            {data.length >= 1 ? (

                <form onSubmit={HandleSubmit} className="calendar-day-form">

                    <Splide aria-label="My Favorite Images">

                        {data && data.map((item, index) => (
                            <SplideSlide>

                                <div key={index}>

                                    <Card sx={{ height: 130 }}>
                                        <CardContent>

                                            <Typography variant="body1" color="warning">
                                                {item.description}
                                            </Typography>
                                            <Typography variant="body1" color="warning">
                                                Type: {item.treiningType}
                                            </Typography>

                                        </CardContent>
                                        <CardActions>
                                            <button value={item.id} onClick={handleAsign} className="calendar-button">
                                                Assign
                                            </button>

                                        </CardActions>
                                    </Card>

                                </div>                        </SplideSlide>

                        ))}
                    </Splide>
                    <label>Give description</label>
                    <input
                        type="text"
                        value={description}
                        onChange={handleInput}
                        required />

                    <label>Localization</label>
                    <input
                        type="text"
                        value={localization}
                        onChange={handleInputloc}
                        required />

                    <input className="submit-button" type="submit" value="Submit" />

                </form>
            ) :
                (<p className='calendar-day-instruction'>Add some Training first</p>)

            }









        </div>
    )
}

export default CalendarOfTraining