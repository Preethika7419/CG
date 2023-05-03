import React, { Component } from 'react'
import { NavLink, Link } from "react-router-dom";

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-primary bg-dark">
                    <div><a href="https://javaguides.net" className="navbar-brand">AdminPage</a></div>
                    <ul className="navbar-nav mr-auto">
          <li class="nav-item">
              <NavLink className="nav-link" exact to="/vehicle">
                viewvehicle
              </NavLink>
            </li>
            
          </ul>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
