import React, { Component } from "react";
import axios from "axios";
import car1 from '../Component/car1.jpg';
//import Vehicle from './Component/Vehicle';


class Vehicle extends Component {
  constructor(props){
    super(props);
    this.state={AllVehicleData:[]}
  }
  componentDidMount() {
    
    axios.get(`http://localhost:8080/user/getVehicle`).then((responseVehicleData)=> {
      console.log(responseVehicleData);
      this.setState({
        AllVehicleData:responseVehicleData.data
        });
      });
     
  }
  bookVehicle(vehicleId){
    this.props.history.push(`/BookingForm/${vehicleId}`);
    
}   
  

  homePage = (event) => {
    // event.preventDefault();
    // alert("send to home page");
    this.props.history.push("/user/getVehicle");
  };
  render() {
   
      
    return(
      <div>
        <div class="row">
          {
             this.state.AllVehicleData.map(
               vehicle=>
           
                 <div class="card col-md-3 offset-md-1 " key={vehicle.vehicleId}>
                   <div class="card-header">
                            <img
                                className="center card-img-top d-block w-100"
                                src={process.env.PUBLIC_URL + vehicle.image}
                                alt="image"
                                width="150"
                                height="150"/>     
                    </div>
                      <div class="card-body">
                        {/* <label>VehicleName:</label>
                        <div> {vehicle.vehicleName}</div> */}
                        
                        <div> {vehicle.vehicleName}</div>
                        
                        <div> {vehicle.color}</div><br/>
                        
                        <div> {vehicle.price}</div>rs<br/>
                        
                        <div> {vehicle.warranty}</div> years warranty
                    </div>
                    <div class="card-footer">
                    <button  style={{marginLeft: "10px"}} 
                                onClick={ () => this.bookVehicle(vehicle.vehicleId)} 
                                className="btn btn-success"> Book </button>

                    </div>
                  </div>
 
             )
           } 

        </div>
      </div>
         
            
         
      
    )
  }
  
}

export default Vehicle;