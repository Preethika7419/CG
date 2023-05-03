import React, { Component } from 'react'

class FooterComponent extends Component {
    constructor(props) {
    super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <footer className = "footer">
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <span className="text-muted">Capgemini</span>
                </nav>
                </footer>
            </div>
        )
    }
}

export default FooterComponent
