import React, { useState } from "react";
import './navbar.css'
import { ReactComponent as Logo } from '../../../assets/logo.svg'
import { Link } from "react-router-dom";


const AdminNavbar = () => {

    const [menuOpen, setMenuOpen] = useState(false);

    const handleMenuToggle = () => {
        setMenuOpen(!menuOpen);
    };
    return (
        <nav className="navbar">
            <div className="logo-container">
                <Logo className="logo" />
            </div>
            <button className="menu-button" onClick={handleMenuToggle}>
                Admin Navbar
            </button>
            <ul className={`menu-list ${menuOpen ? "show" : ""}`}>

                

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