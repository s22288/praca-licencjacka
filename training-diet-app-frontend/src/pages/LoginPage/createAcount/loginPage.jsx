import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./login.css";
import backgroundSVG from "../../../assets/background.svg";
import BackNavbar from "../../../components/Medium/navbar/backNavbar";
import { LoginToUserPage } from "../../../services/usersServices/UserService";

const LoginPage = () => {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [error, setError] = useState("");

    const [status, userStatus] = useState("USER");
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        let login = {
            email: email,
            password: password
        }
        LoginToUserPage(login).then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        }).then(data => {
            const token = data.token;
            localStorage.setItem('jwtToken', token);
            console.log(token)
            return data;
        })
            .catch(error => {
                console.error('Error during registration:', error);
                throw error;
            });
        // DoLogin(email, password)
        //     .then((response) => {
        //         if (response.ok) {
        //             return response.json();
        //         } else {
        //             throw new Error("Invalid credentials");
        //         }
        //     })
        //     .then((data) => {
        //         let authority = data.user.authorities[0].authority;
        //         localStorage.setItem("isLoggedIn", "true");

        //         localStorage.setItem("email", email);
        //         localStorage.setItem("password", password);
        //         localStorage.setItem("role", "normal");

        //         if (authority === "ROLE_USER") {
        //             navigate("/user-page", { state: data });
        //         } else if (authority === "ROLE_ADMIN") {
        //             navigate("/admin-page");
        //         } else if (authority === "ROLE_PREMIUM") {
        //             localStorage.setItem("role", "premium");

        //             navigate("/premium-page");
        //         }
        //     })
        //     .catch((error) => {
        //         console.error("Login failed", error);
        //         setError("Invalid credentials");
        //     });
        navigate('/user-page')
    };

    return (
        <div
            style={{
                backgroundImage: `url(${backgroundSVG})`,
                height: "100vh",
                backgroundSize: "cover",
            }}
        >
            <BackNavbar />
            <form onSubmit={handleSubmit} className="create-account-login-form">
                {error && <p>{error}</p>}

                <label className="customlb">Email:</label>
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <br />

                <label className="customlb">Password:</label>
                <input
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <br />
                <button type="submit" className="login-button">
                    Login
                </button>
            </form>
        </div>
    );
};
export default LoginPage;