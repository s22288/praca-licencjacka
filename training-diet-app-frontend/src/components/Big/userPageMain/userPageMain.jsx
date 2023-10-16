import { Splide, SplideSlide } from "@splidejs/react-splide";
import * as React from "react";


import image1 from "../../../assets/traininguser.jpg";
import image2 from "../../../assets/subscribe.jpg";
import "@splidejs/react-splide/css/sea-green";
import "./userp.css";
import UserPageCard from "./userPageCard/userPageCard";

const UserPageMain = () => {
    let tab1 = {
        img: image1,
        desc: "Training and diet",
        action: "create training",
        to: "/user-page/create-training",
        acces: false,
    };
    let tab2 = {
        img: image2,
        desc: "Premium Subscription",
        action: "buy subscription",
        to: "/",
        acces: true,
    };

    return (
        <Splide aria-label="My Favorite Images">
            <SplideSlide>
                <div className="slide-container">
                    <UserPageCard data={tab1} />
                </div>
            </SplideSlide>
            <SplideSlide>
                <div className="slide-container">
                    <UserPageCard data={tab2} />
                </div>
            </SplideSlide>
        </Splide>
    );
};
export default UserPageMain;