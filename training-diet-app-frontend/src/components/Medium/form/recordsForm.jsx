import { useState } from "react"
import MaxesDiagram from "../../Big/userData/maxesDiagram/maxesdiagram";
import { addUserMaxes } from "../../../services/usersServices/UserService";
import './form-records.css'
import Chart from 'chart.js/auto'; // to musi tu być

const RecordForm = () => {

    const [bench, setBench] = useState(0);
    const [pullups, setPullups] = useState(0);

    const [squad, setSquad] = useState(0);

    const [deadlift, setDeadlift] = useState(0);
    const [dayOfRecord, setDayOfRecords] = useState(Date.now);




    const handleSubmit = () => {

        console.log(bench)
        console.log(pullups)
        console.log(squad)
        console.log(deadlift)
        console.log(dayOfRecord)

        const record = {
            "bench": 100,
            "pullups": 130,
            "squad": 324,
            "deadlift": 213,
            "dayOfRecords": "2022-01-01",
        };

        addUserMaxes(record)

    }

    return (
        <div className="form-container">

            <MaxesDiagram />
            <form onSubmit={handleSubmit} className="form-login-form">
                <label className="form-customlb">Benchpress Max :</label>
                <br></br>
                <input

                    type="number"
                    value={bench}
                    onChange={(e) => setBench(e.target.value)}
                    className="form-user-input" />
                <br />

                <label className="form-customlb">Pullups Max :</label>
                <input

                    type="number"
                    value={pullups}
                    onChange={(e) => setPullups(e.target.value)}
                    className="form-user-input" />
                <br />

                <label className="form-customlb">Squad Max :</label>
                <br></br>

                <input

                    type="number"
                    value={squad}
                    onChange={(e) => setSquad(e.target.value)}
                    className="form-user-input" />
                <br />


                <label className="form-customlb">Deadlift Max :</label>
                <br></br>

                <input

                    type="number"
                    value={deadlift}
                    onChange={(e) => setDeadlift(e.target.value)}
                    className="form-user-input" />
                <br />


                <label className="form-customlb">Date:</label>
                <br></br>
                <input required

                    type="date"
                    value={dayOfRecord}
                    onChange={(e) => setDayOfRecords(e.target.value)}
                    className="form-user-input" />

                <br />


                <button type="submit" className="form-login-button">
                    Add
                </button>
            </form>

        </div >

    )
}

export default RecordForm