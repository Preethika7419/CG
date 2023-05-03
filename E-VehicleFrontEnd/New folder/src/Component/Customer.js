import CustomerNav from "./CustomerNav";
import { BrowserRouter as Router, Route, Switch,Link,NavLink } from "react-router-dom";
import React, { Component } from "react";
import BookingForm from '../Component/BookingForm';
import Profile from '../Component/Profile';
import HomeBg from '../Component/HomeBg';
import Delivery from '../Component/Delivery';
import Vehicle from '../Component/Vehicle';


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
           <Route exact path="/Homebg" component={HomeBg}  />
             
              <Route exact path="/profile" component={Profile}  />
              <Route exact path="/Vehicle" component={Vehicle} />
              <Route exact path="/BookingForm" component={BookingForm} />
              <Route exact path="/Delivery" component={Delivery} />
              
            </Switch>
         </Router>
         </div>
        
      );
    }
  }
  
  export default Customer;