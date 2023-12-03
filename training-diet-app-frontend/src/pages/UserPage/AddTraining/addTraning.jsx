import { useEffect, useState } from "react"
import ChooseTraining from "../../../components/Medium/form/chooseTrainingForm"
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar"
import { checkUserRole } from "../../../services/usersServices/UserService"
import FunctionalityPremiumNavbar from "../../../components/Medium/navbar/functionalityPremiumNavbar"

const AddTranining = () => {
    const [role, setRole] = useState('USER')
    useEffect(() => {

        setRole(checkUserRole());
    }, [])

    return (
        <div>
            {role === 'USER' ? (
                <FunctionalityNavbar />
            ) : (
                <FunctionalityPremiumNavbar />
            )}            <ChooseTraining />
        </div>
    )
}

export default AddTranining;