import { Route, Routes } from "react-router-dom"
import HomePage from "../HomePage/homePage"
import UserPage from "../UserPage/userPage"
import CustomizeDiet from "../CustomizeDietPage/customizeDiet"
import UserData from "../UserPage/UserAccout/userData"
import Records from "../UserPage/UserRecords/record"
import Indicators from "../UserPage/UserIndicators/Indicators"
import AddTranining from "../UserPage/AddTraining/addTraning"
import DietCustomization from "../../components/Big/userData/customizeDiet/CustomizeDiet"
import CreateAccountPage from "../LoginPage/createAcount/createAccount"
import TrainingsPage from "../UserPage/UserTrainings/training"
import DietsPage from "../UserPage/UserDiets/diets"
import MealDetails from "../UserPage/UserDiets/mealDetails/mealDetails"

const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />

      <Route path="/create-acc" element={<CreateAccountPage />} />

      <Route path="/user-page" element={<UserPage />} />
      <Route path="/user-page/customize-diet" element={<CustomizeDiet />} />
      <Route path="/user-page/user-data" element={<UserData />} />
      <Route path="/user-page/records" element={<Records />} />
      <Route path="/user-page/premium-indicators" element={<Indicators />} />
      <Route path="/user-page/create-training" element={<AddTranining />} />
      <Route path="/user-page/create-training/diet-customize" element={<DietCustomization />} />
      <Route path="/user-page/trainings" element={<TrainingsPage />} />
      <Route path="/user-page/diets" element={<DietsPage />} />
      <Route path="user-page/diet/details/:id" element={<MealDetails />} />



    </Routes>
  )
}
export default AllRoutes