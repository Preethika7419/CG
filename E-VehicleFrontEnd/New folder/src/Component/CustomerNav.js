import React, { Component } from "react";
import { NavLink, Link } from "react-router-dom";
class CustomerNav extends Component {
  state = {};
  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-dark bg-secondary">
        

        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
          <li className="nav-item">
              <NavLink className="nav-link active" exact to="/HomeBg">
                Home
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/Profile">
                Profile
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/Vehicle">
                Vehicles
              </NavLink>
            </li> 
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/BookingForm">
                Booking
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link" exact to="/Delivery">
                Delivery Status
              </NavLink>
            </li>
          </ul>
        </div>
        
      </nav>
    );
  }
}

export default CustomerNav;