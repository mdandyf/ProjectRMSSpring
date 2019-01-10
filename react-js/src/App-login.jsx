import React from 'react';
import { FormGroup, FormControl, ControlLabel, Button, Navbar } from 'react-bootstrap';
import "./login.css";

class Login extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: ""
        };
    }

    validateForm() {
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = event => {
        event.preventDefault();
    }

    render() {
        return (
            <div className="container">
                <Content myEmailProp={this.state.email} myPasswordProp={this.state.password}
                    mySubmitProp={this.handleSubmit} myChangeProp={this.handleChange}
                    myValidationProp={this.validateForm} />
            </div>
        );
    }
}

class Content extends React.Component {
    render() {
        return (
            <div className="Login">
                <Navbar inverse={true}>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <a href="#home">PT. Mitrais - RMS</a>
                        </Navbar.Brand>
                    </Navbar.Header>
                </Navbar>
                <form onSubmit={this.props.mySubmitProp}>
                    <FormGroup controlId="email" bsSize="large">
                        <ControlLabel>User Name</ControlLabel>
                        <FormControl
                            autoFocus
                            type="email"
                            value={this.props.myEmailProp}
                            onChange={this.props.myChangeProp}
                        />
                    </FormGroup>
                    <FormGroup controlId="password" bsSize="large">
                        <ControlLabel>Password</ControlLabel>
                        <FormControl
                            value={this.props.myPasswordProp}
                            onChange={this.props.myChangeProp}
                            type="password"
                        />
                    </FormGroup>
                    <Button
                        bsStyle="primary"
                        block
                        bsSize="large"
                        disabled={!this.props.myValidationProp}
                        type="submit"
                    >
                        Login
                </Button>
                </form>
            </div>
        );
    }
}

export default Login;