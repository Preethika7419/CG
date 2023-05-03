import React from 'react';
import UserService from '../Service/UserService';

import {Link} from 'react-router-dom';

class Login extends React.Component{

    constructor(props) {
        super(props)

        this.state = {
            email: '',
            password: '',
            user : {}
        }

        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.validateLogin = this.validateLogin.bind(this);
        this.cancel = this.cancel.bind(this);
    }
    
    changePasswordHandler= (event) => {
        this.setState({password: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    validateLogin = (e) =>
    {
        e.preventDefault();
        let login = {
            email: this.state.email,
            password : this.state.password
        };
        console.log('login => ' + JSON.stringify(login));

       
        UserService.login(login).then( (res) =>{
            
           if(res.status===200)
            {
                this.setState({ user: res.data});
                localStorage.setItem("token",this.state.user.uid);
                console.log("user=>" + JSON.stringify(this.state.user));
                this.props.history.push('/Customer');
            }
        })
        .catch( (error) => {
            console.log("Please Enter Correct Email and Password");
            console.log(error.response);
            document.getElementById('errorMsg').innerHTML=error.response.data;
        });
    }

    cancel = () =>{
        this.props.history.push('/Login');
    }
    newuser = () =>{
        this.props.history.push('/Signup');
    }

    render()
    {
        return(
            <div>
                
            <div className="bgLogin">
            <form className="form1">
                <h2>User Login</h2>
                
                <div id='errorMsg' className="text-danger font-weight-bold"></div>
                
                <div className="form-group">
                    <label>Email address:</label>
                    <input type="email" className="form-control" placeholder="Enter email" 
                    value={this.state.email} onChange={this.changeEmailHandler}/>
                </div>
                <div className="form-group">
                    <label>Password:</label>
                    <input type="password" className="form-control" placeholder="Enter password" 
                    value={this.state.password} onChange={this.changePasswordHandler}/>
                </div>
                <button type="submit" className="btn btn-primary" onClick={this.validateLogin}>Submit</button>
                <button type="reset" className="btn btn-danger ml-3" onClick={this.cancel}>Cancel</button>
                <br/><hr/>
                <button type="button" className="btn btn-success ml-3" onClick={this.newuser}>New User</button>
                <br></br>
                
            </form>
            </div>
            </div>
        );
    }
}
export default Login;