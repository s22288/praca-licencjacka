import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import ButtonBase from '@mui/material/ButtonBase';
import Typography from '@mui/material/Typography';
import './ibw.css'
import img1  from '../../../../../assets/niedowaga.jpg'
import img2  from '../../../../../assets/norma.jpg'
import img3  from '../../../../../assets/nadwaga.jpg'
import img4  from '../../../../../assets/duzanadwaga.jpg'
import img5  from '../../../../../assets/bardzoduzaNadwaga.jpg'
import img6  from '../../../../../assets/megaNadwaga.jpg'
import { useState ,useEffect} from "react";

const images = [
    {
      url: img1,
      title: 'Niedowaga',
      width: '10%',
      isDefault: false,
    },
    {
      url: img2,
      title: 'Norma',
      width: '10%',
      isDefault: false,
  
    },
    
    {
      url: img3,
      title: 'Nadwaga',
      width: '10%',
      isDefault: false,
  
    },
    {
      url: img4,
      title: 'Nadwaga I stopnia',
      width: '10%',
      isDefault: false,
  
    },
    {
      url: img5,
      title: 'Nadwaga II stopnia',
      width: '10%',
      isDefault: false,
  
    },
    {
      url: img6,
      title: 'Nadwaga III stopnia',
      width: '10%',
      isDefault: false,
  
    },
   
  ];
  
const IBWDiagram = (props) => {
    const ibw = useState(props.data);
   
    

    const [message, setMessage] = useState('');
    
    useEffect(() => {
        setIbw(ibw); 
    }, []);
    

    function setIbw(ibw) {
        console.log('dobre ibw ' + ibw);
        if (ibw < 18.5) {
          setMessage('niedowaga');
          images[0].isDefault = true;
        } else if (ibw >= 18.5 && ibw < 24.9) {
          setMessage('norms');
          images[1].isDefault = true;
        } else if (ibw >= 25 && ibw < 29.9) {
          setMessage('nadwaga');
          images[2].isDefault = true;
        } else if (ibw >= 30 && ibw < 34.9) {
          setMessage('otyłość 1 stopnia');
          images[3].isDefault = true;
        } else if (ibw >= 35 && ibw < 39.9) {
          setMessage('otyłość 2 stopnia');
          images[4].isDefault = true;
        } if(ibw > 40) {
          setMessage('otyłość 3 stopnia');
          images[5].isDefault = true;
        }
      }
    return (
        <div>
        <h2 className='diagrams-desc'>IBW wynik: {ibw}</h2>
        <div className="image-container">
          {images.map((image, index) => (
            image.isDefault?(
            <img
              key={index}
              src={image.url}
              alt="ibm indicator"
              className="image-item-unblured"
            />
            ):(
                <img
                key={index}
                src={image.url}
                alt="ibm indicator"
                className="image-item-blured"  />
            )
          ))}
        </div>
      </div>
      
      
    )
}

export default IBWDiagram