import { useEffect, useState } from "react"
import RecordForm from "../../../components/Medium/form/recordsForm"
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar"
import './records.css'
import { checkUserRole } from "../../../services/usersServices/UserService"
import FunctionalityPremiumNavbar from "../../../components/Medium/navbar/functionalityPremiumNavbar"
const Records = () => {
    const [role, setRole] = useState('USER')
    useEffect(() => {

        setRole(checkUserRole());
    }, [])

    return (
        <div className="user-records">
            {role === 'USER' ? (
                <FunctionalityNavbar />
            ) : (
                <FunctionalityPremiumNavbar />
            )}
            <RecordForm />

        </div>
    )
}

export default Records