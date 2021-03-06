import React from 'react';
import { Navbar, FormControl, FormGroup, ControlLabel, Button } from 'react-bootstrap';
import { getLogin } from '../js/api';
import "../css/login.css";
import { ACCESS_TOKEN } from '../js/constants';

class Login extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validateForm() {
        return this.state.username.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = event => {
        event.preventDefault();
        const loginRequest = this.state.username + ':' + this.state.password; 
        getLogin(loginRequest)
            .then(response => {
                if(response.status === 200) {
                    localStorage.setItem(ACCESS_TOKEN, new Buffer(loginRequest).toString("base64"));
                    this.props.onLogin();
                } else  if (response.status === 401) {
                    alert('Your Username or Password is incorrect. Please try again!');
                } else {
                    alert('Sorry! Something went wrong. Please try again!');
                }   
            })
    };

    render() {
        return (
            <div className="container">
                <Content myUsernameProp={this.state.username} myPasswordProp={this.state.password}
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
                            <a href="#home">PT. XYZ - RMS</a>
                        </Navbar.Brand>
                    </Navbar.Header>
                </Navbar>
                <form onSubmit={this.props.mySubmitProp}>
                <FormGroup controlId="username" bsSize="large">
                    <ControlLabel>User Name</ControlLabel>
                    <FormControl
                        autoFocus
                        type="username"
                        value={this.props.myUsernameProp}
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
                    id="buttonSubmit"
                    bsStyle="primary"
                    block
                    bsSize="large"
                    type="submit">
                    Login
                </Button>
            </form>
            </div>
        );
    }
}

export default Login;