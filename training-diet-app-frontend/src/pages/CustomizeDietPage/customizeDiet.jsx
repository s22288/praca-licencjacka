import { useEffect, useState } from "react"
import ButtonWithIcon from "../../components/Small/Button/buttonWithIcon"
import SelectInput from "../../components/Small/inputs/SelectInput"
import calculateCPM from "../../services/usersServices/IndicatorService"

const CustomizeDiet = () => {
   

    return (
        <div>
            <h2>Choose you goal</h2>
            <SelectInput />
           

        </div>
    )
}

export default CustomizeDiet