import { useEffect, useState } from "react"
import MaxesDiagram from "../../Big/userData/maxesDiagram/maxesdiagram";
import { addUserMaxes } from "../../../services/usersServices/UserService";
import './form-records.css'
import Chart from 'chart.js/auto'; // to musi tu być

const RecordForm = () => {

    const [bench, setBench] = useState(0);
    const [pullups, setPullups] = useState(0);

    const [squad, setSquad] = useState(0);

    const [deadlift, setDeadlift] = useState(0);
    const [dayOfRecord, setDayOfRecords] = useState(null);

    useEffect(() => {
        const date = new Date();
        let day = date.getDate();
        let month = date.getMonth() + 1;
        let year = date.getFullYear();

        let currentDate = `${year}-${month}-${day}`;

        setDayOfRecords(currentDate)
    }, [])


    const handleSubmit = () => {
        const record = {
            bench: bench,
            pullups: pullups,
            squad: squad,
            deadlift: deadlift,
            dayOfRecords: dayOfRecord,

        }
        addUserMaxes(record)

    }

    return (
        <div className="container">

            <MaxesDiagram />
            <form onSubmit={handleSubmit} className="login-form">
                <label className="customlb">Benchpress Max :</label>
                <input

                    type="number"
                    value={bench}
                    onChange={(e) => setBench(e.target.value)}
                    className="user-input" />
                <br />

                <label className="customlb">Pullups Max :</label>
                <input

                    type="number"
                    value={pullups}
                    onChange={(e) => setPullups(e.target.value)}
                    className="user-input" />
                <br />

                <label className="customlb">Squad Max :</label>
                <input

                    type="number"
                    value={squad}
                    onChange={(e) => setSquad(e.target.value)}
                    className="user-input" />
                <br />


                <label className="customlb">Deadlift Max :</label>
                <input

                    type="number"
                    value={deadlift}
                    onChange={(e) => setDeadlift(e.target.value)}
                    className="user-input" />
                <br />


                <label className="customlb">Date:</label>
                <input required

                    type="date"
                    value={dayOfRecord}
                    onChange={(e) => setDayOfRecords(e.target.value)}
                    className="user-input" />

                <br />


                <button type="submit" className="login-button">
                    Add
                </button>
            </form>

        </div>

    )
}

export default RecordForm