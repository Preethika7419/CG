import React, { Component } from "react";
import axios from "axios";
import logo from '../logo.svg';
import car1 from './car1.jpg';
class Order extends Component {
  constructor(props){
  super(props);
  this.state={AllBookData:[]}
}
 
  componentDidMount() {
    
    axios.get(`http://localhost:8080/Dealer/getBooking`).then((responseBookData)=> {
      console.log(responseBookData);
      this.setState({
        AllBookData:responseBookData.data
        });
      });
     
  }
  

  Display () {
    // event.preventDefault();
    // alert("send to home page");
    //this.props.history.push("/Dealerpage");
    return(
      alert("Success")
    )
  };
  render() {
    var bookList=this.state.AllBookData.map(
      (book,index)=>
      {
        return (
          <tr>
            <td>{book.orderId}</td>
            <td>{book.vehicle.vehicleId}</td>
            <td>{book.customerName}</td>
            <td>{book.emailId}</td>
            <td>{book.mobileNo}</td>
            <td>{book.address}</td>
            <td>{book.quantity}</td>
          </tr>



        )
      }
    )
    return (
      <div class="dealerdisplay">

          <h1><span className="badge badge-dark">View Orders</span></h1>
            <table className="table table-bordered">
              <tr>
                <th>order Id</th>
                <th>Vehicle Id</th>
                <th>Customer Name</th>
                <th>Email Id</th>
                <th>Mobile no</th>
                <th>Address</th>
                <th>Quantity</th>
              </tr>
              

                {bookList}
              
	          </table>

        <div className="form-group">
          <button className="btn btn-primary" onClick={this.Display}>
            Go Back
          </button>
       </div>
      </div>
     
    );
  }
}

export default Order;