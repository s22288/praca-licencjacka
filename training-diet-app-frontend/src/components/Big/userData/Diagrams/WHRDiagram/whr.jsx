import './whr.css'

const WHRDiagram = (props) => {
    const whr = props.data;

    return (
        <div>
            <h2 className="diagrams-desc">WHR wynik: {whr}</h2>


        </div>
    )
}

export default WHRDiagram