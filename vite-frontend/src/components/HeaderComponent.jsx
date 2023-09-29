import React from 'react';
import { NavLink } from "react-router-dom";
import { isUserLoggedIn, logout } from "../services/AuthServices";
import { useNavigate } from 'react-router-dom'

const HeaderComponent = () => {

  const isAuth = isUserLoggedIn();
  const navigate = useNavigate();

  function handleLogout() {
    logout();
    navigate('/login');
    // redirect("/login");
  }

  return (
    <div>
      <header>
        <nav className="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
          <div className="container-fluid">
            <a className="navbar-brand" href="http://localhost:3000">Navbar</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                    aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"/>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavDropdown">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <a className="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li className="nav-item dropdown">
                  <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                     aria-expanded="false">
                    Dropdown link
                  </a>
                  <ul className="dropdown-menu">
                    <li><a className="dropdown-item" href="#">Action</a></li>
                    <li><a className="dropdown-item" href="#">Another action</a></li>
                    <li><a className="dropdown-item" href="#">Something else here</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            <ul className={"navbar-nav"}>
              {
                !isAuth &&
                <li className="nav-item">
                  <NavLink to={"/register"} className={"nav-link"}>Register</NavLink>
                </li>
              }
              {
                !isAuth &&
                <li className="nav-item">
                  <NavLink to={"/login"} className={"nav-link"}>Login</NavLink>
                </li>
              }
              {
                isAuth &&
                <li className="nav-item">
                  <NavLink to={"/login"} className={"nav-link"} onClick={handleLogout}>Logout</NavLink>
                </li>
              }
            </ul>
          </div>
        </nav>
      </header>
    </div>
  )
}

export default HeaderComponent;