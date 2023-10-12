import RecordForm from "../../../components/Medium/form/recordsForm"
import FunctionalityNavbar from "../../../components/Medium/navbar/functionalitynavbar"
import backgroundSVG from "../../../assets/records.svg"

const Records =()=>{

    return(
        <div   style={{
            backgroundImage: `url(${backgroundSVG})`,
            height: "100vh",
            backgroundSize: "cover",
          }}>
                        <FunctionalityNavbar />
                        <RecordForm/>

        </div>
    )
}

export default  Records