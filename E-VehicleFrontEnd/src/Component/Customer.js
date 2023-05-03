import CustomerNav from "./CustomerNav";
import { BrowserRouter as Router, Route, Switch,Link,NavLink } from "react-router-dom";
import React, { Component } from "react";
import BookingForm from '../Component/BookingForm';
import Profile from '../Component/Profile';
import HomeBg from '../Component/HomeBg';
import Delivery from '../Component/Delivery';
import Vehicle from '../Component/Vehicle';
import Logout from "./Logout";
import Login from "./Login";


class Customer extends Component {
    state = {};
    render() {
      return (
          <div >
              
        
          <Router>
            <CustomerNav />
            <b><i><center>Customer Page</center></i></b>
            
           <Switch>
           <Route exact path="/" component={HomeBg} />
           {/* <Route exact path="/Homebg" component={HomeBg}  /> */}
             
              <Route exact path="/profile" component={Profile}  />
              <Route exact path="/Vehicle" component={Vehicle}  />
             
              <Route exact path="/BookingForm/:vehicleId" component={BookingForm} /> 
              <Route exact path="/Logout" component={Logout}  />
              <Route exact path="/Login" component={Login}  />
              <Route exact path="/HomeBg" component={HomeBg} />
              
            </Switch>
         </Router>
         </div>
        
      );
    }
  }
  
  export default Customer;