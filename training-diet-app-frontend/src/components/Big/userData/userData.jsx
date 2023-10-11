import { useEffect, useState } from "react";
import "./useracc.css";
import { Await, Link, useNavigate } from "react-router-dom";
import MenPhoto from '../../../assets/blackMen.png'

import UserMenuNavbar from "../../Medium/navbar/userMenuNavbar";
import { calculateCaloriesDemandBaseOnUser, getUserData, updateUsersData } from "../../../services/usersServices/UserService";
import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";
import FunctionalityNavbar from "../../Medium/navbar/functionalitynavbar";

const UserAccount = () => {
    const [birthDate, setBirthDate] = useState('');
    const [height, setHeight] = useState('');
    const [weight, setWeight] = useState('');
    const [pal, setPal] = useState(0);

    const [userData, setUserData] = useState(null);
    useEffect(() => {
        getUserData()
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Failed to fetch user data");
                }
            })
            .then((data) => {
                setUserData(data);
                setBirthDate(data.birthDate)
                setWeight(data.weight)

                setHeight(data.height)
                setPal(data.palfactor)

            })
            .catch((error) => {
                console.error("Failed to fetch user data", error);
            });



    }, []);


    const palArray = [
        {
            val: 1.2,
            mess: 'Brak aktywności zawodowej, chory, leżący'
        },
        {
            val: 1.4,
            mess: 'Pracownik biurowy, którego aktywność związana jest wyłącznie z obowiązkami domowymi'
        },
        {
            val: 1.6,
            mess: 'Pracownik biurowy, trenujący 2-3 razy w tygodniu przez minimum godzinę'
        },
        {
            val: 1.8,
            mess: 'Pracownik biurowy, trenujący 3-4 razy w tygodniu przez minimum godzinę'
        },
        {
            val: 2.0,
            mess: 'Zawodowy sportowiec, trenujący minimum 6 godzin tygodniowo lub osoba ciężko pracująca fizycznie'
        }

    ]
  
    const handleSubmit = (event) => {
        event.preventDefault();


        const data = {
            birthDate: birthDate,
            height: height,
            weight: weight,
            palfactor: pal
        };

        updateUsersData(data) .then(() => {
            setUserData({
                ...userData,
                birthDate: data.birthDate,
                height: data.height,
                weight: data.weight,
                palfactor: data.palfactor
            });
        })
        .catch((error) => {
            console.error("Failed to update user data", error);
            // Handle error and provide feedback to the user
        });
       



    };

    const handleChange = (event) => {
        setPal(event.target.value)
    }



    return (
        <div
            style={{

                height: "100vh",
                backgroundSize: "cover",
            }}
        >
            <FunctionalityNavbar />




            <div className="container-account">
                <div className="content">
                    <div className="image-container">
                        {userData ? (
                            userData.photo ? (
                                <img src={MenPhoto} alt="User Photo" className="image" />

                            ) :
                                <img src={userData.photo} alt="User Photo" className="image" />


                        ) : (
                            <div className="placeholder-image" />
                        )}
                    </div>
                    <div className="data-container">
                        <h1 className="title">User Data</h1>
                        {userData ? (
                            <div>
                                {userData.mail ? (
                                    <p className="text">Email: {userData.mail}</p>
                                ) : (
                                    <p className="text">Email: ?</p>
                                )}

                                {userData.login ? (
                                    <p className="text">Login: {userData.login}</p>
                                ) : (
                                    <p className="text">Login: ?</p>
                                )}

                                {userData.birthDate ? (
                                    <p className="text">BirthDate: {userData.birthDate}</p>
                                ) : (
                                    <p className="text">BirthDate: ?</p>
                                )}
                                {userData.height ? (
                                    <p className="text">Height: {userData.height}</p>
                                ) : (
                                    <p className="text">Height: ?</p>
                                )}
                                {userData.weight ? (
                                    <p className="text">Weight: {userData.weight}</p>
                                ) : (
                                    <p className="text">Weight: ?</p>
                                )}
                            </div>
                        ) : (
                            <p className="text">No user data available.</p>
                        )}
                    </div>

                    <form onSubmit={handleSubmit} className="login-form">
                        <label className="customlb">BrithDate:</label>
                        <input

                            type="date"
                            value={birthDate}
                            onChange={(e) => setBirthDate(e.target.value)}
                            className="user-input" />
                        <br />

                        <label className="customlb">Height:</label>
                        <input

                            type="number"
                            value={height}
                            onChange={(e) => setHeight(e.target.value)}
                            className="user-input" />
                        <br />

                        <label className="customlb">Weight:</label>
                        <input

                            type="number"
                            value={weight}
                            onChange={(e) => setWeight(e.target.value)}
                            className="user-input" />
                        <br />
                        <FormControl fullWidth >

                            <InputLabel id="demo-simple-select-label">Pal</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={pal}
                                label="Age"
                                onChange={handleChange}
                            >
                                <MenuItem value={palArray[0].val} className="menu-item-text">{palArray[0].mess} : {palArray[0].val} </MenuItem>
                                <MenuItem className="menu-item-text" value={palArray[1].val}>{palArray[1].mess} : {palArray[1].val}</MenuItem>
                                <MenuItem className="menu-item-text" value={palArray[2].val}>{palArray[2].mess} : {palArray[2].val}</MenuItem>
                                <MenuItem className="menu-item-text" value={palArray[3].val}>{palArray[3].mess} : {palArray[3].val}</MenuItem>
                                <MenuItem className="menu-item-text" value={palArray[4].val}>{palArray[4].mess} : {palArray[4].val}</MenuItem>

                            </Select>
                        </FormControl>

                        <button type="submit" className="login-button">
                            Update
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
};
export default UserAccount;