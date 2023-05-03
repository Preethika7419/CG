import React, { Component } from "react";
import { NavLink, Link } from "react-router-dom";
class Navbar extends Component {
  state = {};
  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-light bg-info">
        <a className="navbar-brand">E Vehicle Management</a>

        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
          <li class="nav-item">
              <NavLink className="nav-link" exact to="/HomeBg">
                Home
              </NavLink>
            </li>
            <li className="nav-item">

              <NavLink className="nav-link" exact to="/Vehicledisplay">
                Vehicle
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/Contact">
                About Us
              </NavLink>
            </li>
            
            
           
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/Login">
                Login
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/AdminVehicle" >
              Admin
              </NavLink> 
              
            </li>
          </ul>
        </div>
        
      </nav>
    );
  }
}

export default Navbar;