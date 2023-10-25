import PremiumUserIndicators from "../../../components/Big/userData/userIndicators/indicators";
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar";
import backgroundSVG from "../../../assets/background.svg"
import './indicators.css'
const Indicators = () => {
    return (
        <div className="user-indicators-background" >
            <FunctionalityNavbar />
            <PremiumUserIndicators />
        </div>)
}

export default Indicators;