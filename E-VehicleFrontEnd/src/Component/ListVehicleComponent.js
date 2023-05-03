import React, { Component } from 'react'
import VehicleService from '../Component/VehicleService';

class ListVehicleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vehicles: []
        }
        this.addVehicle = this.addVehicle.bind(this);
        this.editVehicle = this.editVehicle.bind(this);
        this.deleteVehicle = this.deleteVehicle.bind(this);
    }

    deleteVehicle(vehicleId){
        VehicleService.deleteVehicle(vehicleId).then( res => {
            this.setState({vehicles: this.state.vehicles.filter(vehicle => vehicle.vehicleId !== vehicleId)});
        });
    }
    viewVehicle(vehicleId){
        this.props.history.push(`/view-vehicle/${vehicleId}`);
    }
    editVehicle(vehicleId){
        this.props.history.push(`/add-vehicle/${vehicleId}`);
    }

    componentDidMount(){
        VehicleService.getVehicles().then((res) => {
            this.setState({ vehicles: res.data});
        });
    }

    addVehicle(){
        this.props.history.push('/add-vehicle/_add'); //change
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Vehicle List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addVehicle}> Add Vehicle</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Vehicle Name</th>
                                    <th> Category</th>
                                    <th> Color</th>
                                    <th>Warranty</th>
                                    <th> Price</th>
                                    <th> Quantity</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.vehicles.map(
                                        vehicle => 
                                        <tr key = {vehicle.vehicleId}>
                                             <td> {vehicle.vehicleName} </td>   
                                             <td> {vehicle.category}</td>
                                             <td> {vehicle.color}</td>
                                             <td> {vehicle.warranty}</td>
                                             <td> {vehicle.price}</td>
                                             <td> {vehicle.quantity}</td>
                                             <td>
                                                 <button onClick={ () => this.editVehicle(vehicle.vehicleId)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVehicle(vehicle.vehicleId)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVehicle(vehicle.vehicleId)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListVehicleComponent
