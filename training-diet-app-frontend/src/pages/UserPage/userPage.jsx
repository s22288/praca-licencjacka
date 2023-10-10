import { Link } from "react-router-dom"

const UserPage = () => {
    return (
        <div>
            <h2>user-page</h2>
            <Link to={'/user-page/customize-diet'}>CustomiseDiet</Link>
            <br>
            </br>
            <Link to={'/user-page/user-data'}>userData</Link>

        </div>
    )
}

export default UserPage