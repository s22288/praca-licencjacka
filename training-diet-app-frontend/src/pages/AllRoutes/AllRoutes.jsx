import { Route, Routes } from "react-router-dom"
import HomePage from "../HomePage/homePage"
import UserPage from "../UserPage/userPage"
import CustomizeDiet from "../CustomizeDietPage/customizeDiet"
import UserData from "../UserPage/userData"

const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/user-page" element={<UserPage />} />
      <Route path="/user-page/customize-diet" element={<CustomizeDiet />} />
      <Route path="/user-page/user-data" element={<UserData />} />

    </Routes>
  )
}
export default AllRoutes