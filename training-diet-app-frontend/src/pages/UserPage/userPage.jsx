


import backgroundSVG from "../../assets/userpage.svg";
import { useNavigate } from "react-router-dom";

import UserNavbar from "../../components/Medium/navbar/userNavbar";
import UserPageMain from "../../components/Big/userPageMain/userPageMain";

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
      <UserPageMain />
    </div>
  );
};

export default UserPage;