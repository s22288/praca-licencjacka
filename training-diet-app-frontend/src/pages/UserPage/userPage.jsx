


import backgroundSVG from "../../assets/userpage.svg";
import { useNavigate } from "react-router-dom";

import UserNavbar from "../../components/Medium/navbar/userNavbar";

const UserPage = () => {
  const navigate = useNavigate();

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <UserNavbar />
     
    </div>
  );
};

export default UserPage;