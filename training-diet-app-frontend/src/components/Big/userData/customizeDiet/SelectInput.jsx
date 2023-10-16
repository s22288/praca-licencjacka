import { FormControl, MenuItem, Select } from "@mui/material"
import { useEffect, useState } from "react";
import calculateCPM from "../../../../services/usersServices/IndicatorService";

const SelectDietGoal = () => {
    const [cpm, setCpm] = useState()
    const [cpmCopy, setCpmCopy] = useState();

    useEffect(() => {



        calculateCPM()
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Failed to fetch user data");
                }
            })
            .then((d) => {

                setCpm(d);




            })
            .catch((error) => {
                console.error("Failed to fetch user data", error);
            });

    }, []);
    const handleChange = (event) => {
        setCpmCopy(cpm)
        let goalSett = event.target.value

        if (goalSett === 'lose') {
            setCpmCopy((cpm - 300).toFixed(2))
        }

        if (goalSett === 'gain') {
            setCpmCopy((cpm + 300).toFixed(2))

        }
    }

    let age
    return (
        <div>
            <FormControl fullWidth>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={age}
                    label="Age"
                    onChange={handleChange}
                >
                    <MenuItem value={'lose'}>Lose Weight</MenuItem>
                    <MenuItem value={'maintain'}>Maintain Weight</MenuItem>
                    <MenuItem value={'gain'}>Gain Weight</MenuItem>
                </Select>
            </FormControl>
            <h2>you need {cpmCopy} kcal</h2>
        </div>
    )
}

export default SelectDietGoal