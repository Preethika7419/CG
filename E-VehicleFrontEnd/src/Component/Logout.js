import React from 'react';

import Alert from 'react-bootstrap/Alert';
import logout from '../Component/Images/logout.png';

class Logout extends React.Component{

    constructor(props) {
        super(props);
        localStorage.removeItem("token");
    }
    back = () =>{
        this.props.history.push('/Login');
    }

    render()
    {
        return(
            <div>
                
            <div className="container">
                <Alert variant="success">Logged-Out Successfully....</Alert>
                <button type="button" className="btn btn-warning ml-3" onClick={this.back}>Go back</button>
                <img
                     className="center d-block w-100"
                    src={logout}
                    alt="Vehicle"
                    width="250"
                    height="550"/>     
            </div>
            </div>
        );
    }
}
export default Logout;