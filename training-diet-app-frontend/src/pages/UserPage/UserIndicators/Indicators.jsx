import PremiumUserIndicators from "../../../components/Big/userData/userIndicators/indicators";
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar";
import backgroundSVG from "../../../assets/background.svg"

const Indicators = () => {
    return (<div  style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
    }}>
        <FunctionalityNavbar />
        <PremiumUserIndicators />
    </div>)
}

export default Indicators;