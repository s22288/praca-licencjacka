import { useEffect, useState } from "react";
import OwnDiets from "../../../components/Big/ownDiets/ownDiets";
import FunctionalityPremiumNavbar from "../../../components/Medium/navbar/functionalityPremiumNavbar";
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar";
import { checkUserRole } from "../../../services/usersServices/UserService";


const DietsPage = () => {
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
            )}
            <OwnDiets />
        </div>
    );
};

export default DietsPage;