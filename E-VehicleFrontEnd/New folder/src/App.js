import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import Dealer from './Component/Order'; 
import ViewVehicleComponent from './Component/ViewVehicleComponent';
import Navbar from './Component/Navbar';
import BookingForm from './Component/BookingForm';
import Home from './Component/Vehicle';
import Contact from './Component/Contact';
import car1 from'./Component/car1.jpg';
import Customer from './Component/Customer';
import HomeBg from './Component/HomeBg';
import Login from './Component/Login';
import { BrowserRouter as Router, Route, Switch,Link,NavLink } from "react-router-dom";
import Vehicle from './Component/Vehicle';
import preethi from './Component/preethi';
import Signup from './Component/Signup';


class App extends Component {
  state = {};
  render() {
    return (
      
        <Router>
          <Navbar />
          
          <Switch>
           
          <Route exact path="/HomeBg" component={HomeBg}  />
            <Route exact path="/Vehicle" component={Vehicle}  />
            <Route exact path="/Contact" component={Contact} />
  
            <Route exact path="/BookingForm/:vehicleId" component={BookingForm} />
            <Route exact path="/Customer" component={Customer}/>
            <Route exact path="/Login" component={Login}/>
            <Route exact path="/Signup" component={Signup}/>
            

            
          </Switch>
        </Router>
      
    );
  }
}

export default App;
