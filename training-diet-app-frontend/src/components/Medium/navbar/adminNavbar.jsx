import React, { useState } from "react";
import './navbar.css'
import { ReactComponent as Logo } from '../../../assets/data.svg'
import { Link } from "react-router-dom";
import { colors } from "@mui/material";


const AdminNavbar = () => {

    const [menuOpen, setMenuOpen] = useState(false);

    const handleMenuToggle = () => {
        setMenuOpen(!menuOpen);
    };
    return (
        <nav className="admin-navbar">
            <div className="logo-container">
                <Logo className="logo" />
            </div>
            <p className="admin-text" >admin</p>
           
            <button className="menu-button" onClick={handleMenuToggle}>
                Admin Navbar
            </button>

            <ul className={`menu-list ${menuOpen ? "show" : ""}`}>

            <li>
                    <Link to="/admin-page" className="nav-link">
                        Panel
                    </Link>
                </li>

                <li>
                    <Link to="/" className="nav-link">
                        logout
                    </Link>
                </li>

            </ul>
        </nav>
    )
}

export default AdminNavbar