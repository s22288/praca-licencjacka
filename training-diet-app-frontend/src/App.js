import { useEffect } from "react";
import AllRoutes from "./pages/AllRoutes/AllRoutes";
import { useLocation } from "react-router-dom";
import { useAuthenticate } from "./services/usersServices/UserService";

function App() {
  useAuthenticate()
  return (
    <div>
      <AllRoutes />
    </div>
  );
}

export default App;
