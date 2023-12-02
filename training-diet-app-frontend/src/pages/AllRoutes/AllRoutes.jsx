import { Route, Routes, createBrowserRouter } from "react-router-dom"
import HomePage from "../HomePage/homePage"
import UserPage from "../UserPage/userPage"
import UserData from "../UserPage/UserAccout/userData"
import Records from "../UserPage/UserRecords/record"
import Indicators from "../UserPage/UserIndicators/Indicators"
import AddTranining from "../UserPage/AddTraining/addTraning"
import DietCustomization from "../../components/Big/userData/customizeDiet/CustomizeDiet"
import CreateAccountPage from "../LoginPage/createAcount/createAccount"
import TrainingsPage from "../UserPage/UserTrainings/training"
import DietsPage from "../UserPage/UserDiets/diets"
import MealDetails from "../UserPage/UserDiets/mealDetails/mealDetails"
import ExcerciseDetails from "../UserPage/UserTrainings/ExerciseDetails/exerciseDetails"
import TrainingsCalendar from "../UserPage/CalendarOFTrainings/trainingsCalendar"
import TrainingCustomization from "../../components/Big/userData/customizeTraining/CutsomizeTraining"
import SmallTrainigDetails from "../../components/Big/ownTrainings/smallTrainingDetails"
import AdminPanel from "../AdminPanel/adminPage"
import LoginPage from "../LoginPage/createAcount/loginPage"
import UserPagePremium from "../UserPage/userPagePremium"
import EditExercise from "../../components/Big/AdminPage/editExercise"
import EditMeal from "../../components/Big/AdminPage/editMeal"
import { authenticate } from "../../services/usersServices/UserService"
import { useEffect } from "react"

const AllRoutes = () => {

  // const router = createBrowserRouter([
  //   {
  //     id: 'root',
  //     path: '/',
  //     loader: authenticate,
  //     element: < HomePage />,

  //     children: [

  //       { path: '/create-acc', element: <CreateAccountPage /> },
  //       { path: '/login', element: <LoginPage /> },
  //       { path: '/user-page', element: <UserPage /> },
  //       { path: '/premium-user-page', element: <UserPagePremium /> },
  //       { path: '/admin-page', element: <AdminPanel /> },
  //       { path: '/admin-page/edit-exercise/:id', element: <EditExercise /> },
  //       { path: '/admin-page/edit-meal/:id', element: <EditMeal /> },
  //       { path: '/user-page/user-data', element: <UserData /> },
  //       { path: '/user-page/records', element: <Records /> },
  //       { path: '/user-page/premium-indicators', element: <Indicators /> },
  //       { path: '/user-page/create-training', element: <AddTranining /> },
  //       { path: '/user-page/create-training/diet-customize', element: <DietCustomization /> },
  //       { path: '/user-page/trainings', element: <TrainingsPage /> },
  //       { path: '/user-page/diets', element: <DietsPage /> },
  //       { path: 'user-page/diet/details/:id', element: <MealDetails /> },
  //       { path: '/user-page/training/details/:id', element: <ExcerciseDetails /> },
  //       { path: '/user-page/calendar', element: <TrainingsCalendar /> },
  //       { path: '/user-page/create-training/train-customize', element: <TrainingCustomization /> },
  //       { path: '/user-page/calendar/details/:id', element: <SmallTrainigDetails /> },
  //     ],
  //   },
  // ]);

  return (
    <Routes>
      <Route path="/" element={<HomePage />} />

      <Route path="/create-acc" element={<CreateAccountPage />} />
      <Route path="/login" element={<LoginPage />} />

      <Route path="/user-page" element={<UserPage />} />
      <Route path="/premium-user-page" element={<UserPagePremium />} />

      <Route path="/admin-page" element={<AdminPanel />} />
      <Route path="/admin-page/edit-exercise/:id" element={<EditExercise />} />
      <Route path="/admin-page/edit-meal/:id" element={<EditMeal />} />

      <Route path="/user-page/user-data" element={<UserData />} />
      <Route path="/user-page/records" element={<Records />} />
      <Route path="/user-page/premium-indicators" element={<Indicators />} />
      <Route path="/user-page/create-training" element={<AddTranining />} />
      <Route path="/user-page/create-training/diet-customize" element={<DietCustomization />} />
      <Route path="/user-page/trainings" element={<TrainingsPage />} />
      <Route path="/user-page/diets" element={<DietsPage />} />
      <Route path="user-page/diet/details/:id" element={<MealDetails />} />
      <Route path="/user-page/training/details/:id" element={<ExcerciseDetails />} />
      <Route path="/user-page/calendar" element={<TrainingsCalendar />} />

      <Route path="/user-page/create-training/train-customize" element={<TrainingCustomization />} />
      <Route path="/user-page/calendar/details/:id" element={<SmallTrainigDetails />} />

    </Routes>
  )
}
export default AllRoutes