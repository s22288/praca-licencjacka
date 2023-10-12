import { useEffect, useState } from "react"
import { getUserMaxes } from "../../../../services/usersServices/UserService"
import LineChart from "./linecharts";
import './maxes.css'
const MaxesDiagram =()=>{
const [userMaxes,setUserMaxes] = useState([]);
    useEffect(()=>{
getUserMaxes().then((response) => {
    if (response.ok) {
        return response.json();
    } else {
        throw new Error("Failed to fetch user data");
    }
})
.then((data) => {
    setUserMaxes(data)
})
.catch((error) => {
    console.error("Failed to fetch user data", error);
});


    },[])
    return(
<div>
    <LineChart data={userMaxes}/>
</div>
    )
}

export default MaxesDiagram;