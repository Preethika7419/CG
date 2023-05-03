import React from 'react';
//import logo from './logo.svg';

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListVehicleComponent from '../Component/ListVehicleComponent';
import HeaderComponent from '../Component/HeaderComponent';
//import FooterComponent from './components/FooterComponent';
import CreateVehicleComponent from '../Component/CreateVehicleComponent';
import ViewVehicleComponent from '../Component/ViewVehicleComponent';

function AdminVehicle() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListVehicleComponent}></Route>
                          <Route path = "/vehicle" component = {ListVehicleComponent}></Route>
                          <Route path = "/add-vehicle/:id" component = {CreateVehicleComponent}></Route>
                          <Route path = "/view-vehicle/:id" component = {ViewVehicleComponent}></Route>
                          
                    </Switch>
                </div>
            
        </Router>
    </div>
    
  );
}

export default AdminVehicle;