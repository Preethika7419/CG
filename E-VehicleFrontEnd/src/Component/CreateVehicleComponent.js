import React, { Component } from 'react'
import VehicleService from '../Component/VehicleService';

class CreateVehicleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
        id: this.props.match.params.id,
		category: '',
		vehicleName: '',
		color: '',
		warranty: '',
		price: '',
        quantity: ''
        }
        this.changeVehicleNameHandler = this.changeVehicleNameHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeColorHandler = this.changeColorHandler.bind(this);
        this.changeWarrantyHandler = this.changeWarrantyHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.saveOrUpdateVehicle = this.saveOrUpdateVehicle.bind(this);
    }

    // step 3
    componentDidMount(){

    // step 4
        if(this.state.vehicleId === '_add'){
            return
        }else{
            VehicleService.getVehicleById(this.state.vehicleId).then( (res) =>{
                let vehicle = res.data;
                this.setState({
                    vehicleId: vehicle.vehicleId,
                    vehicleName: vehicle.vehicleName,
		            category: vehicle.category,
		            color: vehicle.color,
		            warranty: vehicle.warranty,
		            price: vehicle.price,
                    quantity: vehicle.quantity
                    
                });
            });
        }        
    }
    saveOrUpdateVehicle = (e) => {
        e.preventDefault();
    let vehicle = {vehicleId: this.state.vehicleId, vehicleName: this.state.vehicleName, category: this.state.category, color: this.state.color, warranty: this.state.warranty, price: this.state.price, quantity: this.state.quantity};
        console.log('vehicle => ' + JSON.stringify(vehicle));

        // step 5

        if(this.state.vehicleId === '_add'){
            VehicleService.createVehicle(vehicle).then(res =>{
                this.props.history.push('/vehicle');
            });
        }else{
            VehicleService.updateVehicle(vehicle, this.state.vehicleId).then( res => {
                this.props.history.push('/vehicle');
            });
        }
    }
    
    changeVehicleNameHandler= (event) => {
        this.setState({vehicleName: event.target.value});
    }

    changeCategoryHandler= (event) => {
        this.setState({category: event.target.value});
    }

    changeColorHandler= (event) => {
        this.setState({color: event.target.value});
    }

    changeWarrantyHandler= (event) => {
        this.setState({warranty: event.target.value});
    }

    changePriceHandler= (event) => {
        this.setState({price: event.target.value});
    }

    changeQuantityHandler= (event) => {
        this.setState({quantity: event.target.value});
    }

    cancel(){
        this.props.history.push('/vehicle');
    }

    getTitle(){
        if(this.state.vehicleId === '_add'){
            return <h3 className="text-center">Add New Vehicle</h3>
        }else{
            return <h3 className="text-center">Update Vehicle Details</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                    <div className = "form-group">
                                            <label> Vehicle Name </label>
                                            <input placeholder="Enter Vehicle Name" name="vehicleName" className="form-control" 
                                                value={this.state.vehicleName} onChange={this.changeVehicleNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Category: </label>
                                            <input placeholder="Enter Category" name="category" className="form-control" 
                                                value={this.state.category} onChange={this.changeCategoryHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Color: </label>
                                            <input placeholder="Enter Color" name="color" className="form-control" 
                                                value={this.state.color} onChange={this.changeColorHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Warranty: </label>
                                            <input placeholder="Enter Warranty" name="warranty" className="form-control" 
                                                value={this.state.warranty} onChange={this.changeWarrantyHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Price: </label>
                                            <input placeholder="Enter Price" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Quantity: </label>
                                            <input placeholder="Enter Quantity" name="quantity" className="form-control" 
                                                value={this.state.quantity} onChange={this.changeQuantityHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVehicle}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateVehicleComponent
