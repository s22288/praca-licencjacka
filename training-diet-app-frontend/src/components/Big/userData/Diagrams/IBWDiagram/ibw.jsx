import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import ButtonBase from '@mui/material/ButtonBase';
import Typography from '@mui/material/Typography';
import './ibw.css'

import { useEffect} from "react";


const IBWDiagram = (props) => {
    const {ibw} = props.data
   
    

   
       
  
    

   
    return (
        <div>
        <h2 className='diagrams-desc'>IBW wynik: {ibw}</h2>
       
      </div>
      
      
    )
}

export default IBWDiagram