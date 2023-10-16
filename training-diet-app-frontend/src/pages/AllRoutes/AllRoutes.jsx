import { Route, Routes } from "react-router-dom"
import HomePage from "../HomePage/homePage"
import UserPage from "../UserPage/userPage"
import CustomizeDiet from "../CustomizeDietPage/customizeDiet"
import UserData from "../UserPage/UserAccout/userData"
import Records from "../UserPage/UserRecords/record"
import Indicators from "../UserPage/UserIndicators/Indicators"
import AddTranining from "../UserPage/AddTraining/addTraning"

const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/user-page" element={<UserPage />} />
      <Route path="/user-page/customize-diet" element={<CustomizeDiet />} />
      <Route path="/user-page/user-data" element={<UserData />} />
      <Route path="/user-page/records" element={<Records />} />
      <Route path="/user-page/premium-indicators" element={<Indicators />} />
      <Route path="/user-page/create-training" element={<AddTranining />} />

    </Routes>
  )
}
export default AllRoutes