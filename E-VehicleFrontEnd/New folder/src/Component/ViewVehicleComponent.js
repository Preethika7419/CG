import React, { Component } from 'react'
import VehicleService from '../Component/VehicleService'

class ViewVehicleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            vehicleId: this.props.match.params.vehicleId,
            vehicle: {}
        }
    }

    componentDidMount(){
        VehicleService.getVehicleById(this.state.vehicleId).then( res => {
            this.setState({vehicle: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Vehicle Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Vehicle Name: </label>
                            <div> { this.state.vehicle.vehicleName }</div>
                        </div>
                        <div className = "row">
                            <label> Category: </label>
                            <div> { this.state.vehicle.category }</div>
                        </div>
                        <div className = "row">
                            <label> Year Of Manufacture: </label>
                            <div> { this.state.vehicle.yearOfManu }</div>
                        </div>
                        <div className = "row">
                            <label> Model: </label>
                            <div> { this.state.vehicle.modelName }</div>
                        </div>
                        <div className = "row">
                            <label> Color: </label>
                            <div> { this.state.vehicle.color }</div>
                        </div>
                        <div className = "row">
                            <label> Warranty: </label>
                            <div> { this.state.vehicle.warranty }</div>
                        </div>
                        <div className = "row">
                            <label> Price: </label>
                            <div> { this.state.vehicle.price }</div>
                        </div>
                        <div className = "row">
                            <label> Quantity: </label>
                            <div> { this.state.vehicle.quantity }</div>
                        </div>
                        <div className = "row">
                            <label> Dealer Name: </label>
                            <div> { this.state.vehicle.dealerName }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewVehicleComponent;