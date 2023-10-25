import './whr.css'

const WHRDiagram = (props) => {
    const whr = props.data;

    return (
        <div>
            <h2 className="whrdiagramtext">WHR wynik: {whr}</h2>


        </div>
    )
}

export default WHRDiagram