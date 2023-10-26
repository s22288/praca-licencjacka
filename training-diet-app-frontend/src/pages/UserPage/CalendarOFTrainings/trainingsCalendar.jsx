import CalendarOfTraining from "../../../components/Big/userData/calendar/calendar"
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar"
import './trainingCalendar.css'
const TrainingsCalendar = () => {
    return (
        <div className="calendar-background">
            <FunctionalityNavbar />
            <CalendarOfTraining />
        </div>
    )
}
export default TrainingsCalendar