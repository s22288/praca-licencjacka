
import { useState } from 'react';
import Diagram from './diagra';

const BMIDiagram = (props) => {

    const bmi = props.bmi;
    const dataOfUser = props.data;

    // console.log(dataOfUser)

    const asignToGroup = (bmi) => {
        if (bmi < 18.5) {
            return 'Niedowaga'
        }
        if (bmi > 18.5 && bmi < 25) {
            return 'Norma'
        }
        if (bmi > 25 && bmi < 30) {
            return 'Nadwaga'
        }
        if (bmi > 30 && bmi < 35) {
            return 'Otyłość'
        }
        return 'Otyłość kliniczna'
    }
    let wynik = asignToGroup(bmi)
    return (
        <div>
            <h3>{bmi}</h3>
            <h2>BMI</h2>
            <h3>{wynik}</h3>
            <Diagram data={dataOfUser} />


        </div>
    )
}

export default BMIDiagram