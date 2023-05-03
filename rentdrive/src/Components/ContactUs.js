import React from 'react';
import UserService from '../Service/UserService';
import Navbar from '../Navbars/Navbar';
import Contact from '../Images/contact.jpg';

class ContactUs extends React.Component{
    constructor(props) {
        super(props)

        this.state = {
            email: '',
            name: '',
            Message: '',
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeMessageHandler = this.changeMessageHandler.bind(this);
    }
    
    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeMessageHandler= (event) => {
        this.setState({message: event.target.value});
    }

    save = (e) => {
        e.preventDefault();
        let enquiry = {
                            name: this.state.name,
                            email: this.state.email,
                            details: this.state.message,
                        };
        console.log('enquiry => ' + JSON.stringify(enquiry));
    
        UserService.addEnquiry(enquiry).then( (res) =>{
                alert("Your Query is added succesfully");
                this.props.history.push('/');
        })
        .catch( (error) => {
            alert("Your query is not registered successfully");
        });
    }
    cancel(){
        this.props.history.push('/contactUs');
    }
    render()
    {
        return(
            <div className="bgContact">
                <Navbar/>
                <div className="centerContact">
                <form className="container">
                <h1 className="text-primary mt-3 pt-2">GET IN TOUCH</h1>
                <div className="form-group">
                    <label >Name:</label>
                    <input className="form-control" placeholder="Enter Name" name="name"
                    value={this.state.name} onChange={this.changeNameHandler} />
                </div>
                <div className="form-group">
                    <label>Email address:</label>
                    <input type="email" className="form-control" name="email" placeholder="Enter email" 
                    value={this.state.email} onChange={this.changeEmailHandler}/>
                </div>
                <div className="form-group">
                    <label >Message:</label>
                    <input className="form-control" placeholder="Enter Your Message" name="message"
                    value={this.state.message} onChange={this.changeMessageHandler}/>
                </div>
                <button type="submit" className="btn btn-primary mb-3" onClick={this.save}>Submit</button>
                <button type="reset" className="btn btn-danger ml-3 mb-3" onClick={this.cancel.bind(this)}>Cancel</button>
                 </form>
                 </div>
                    <h4 className="text-light text-center pt-2">rentdrivehelpdesk@hotmail.com</h4>
                    <h4 className="text-light text-center pt-2">+91 279240280324</h4>
                    <h4 className="text-light text-center pt-2">+91 279242555524</h4>
            </div>
        );
    }
}
export default ContactUs;