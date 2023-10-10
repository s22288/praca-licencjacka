import { Link } from "react-router-dom"
const HomePage = () => {
    return (
        <div>
            <h2>home page</h2>
            <ul>
                <li>
                    <Link to={'/user-page'}>User page</Link>
                </li>
                <li>
                    <Link to={'/user-page'}>User page</Link>

                </li>
                <li>
                    <Link to={'/user-page'}>User page</Link>

                </li>
            </ul>
        </div>
    )
}

export default HomePage