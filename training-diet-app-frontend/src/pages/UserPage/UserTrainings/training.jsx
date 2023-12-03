import { useEffect, useState } from "react";
import OwnTrainings from "../../../components/Big/ownTrainings/owntraining";
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar";
import { checkUserRole } from "../../../services/usersServices/UserService";
import FunctionalityPremiumNavbar from "../../../components/Medium/navbar/functionalityPremiumNavbar";

const TrainingsPage = () => {
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
            )}            <OwnTrainings />
        </div>
    );
};

export default TrainingsPage;