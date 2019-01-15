import React from 'react';
import { FormGroup, FormControl, ControlLabel, Button, Navbar } from 'react-bootstrap';
import "../css/login.css";

class Login extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };

        this.handleChange = this.handleChange.bind(this);

        if (props.error) {
            this.state = {
                failure: "Wrong username or password!",
                errcount: 0
            }
        } else {
            this.state = { errcount: 0 }
        }
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
        if (!this.state.errcount) {
            const data = new FormData(this.state.username, this.state.password);
            fetch('http://localhost:8080/login', {
                method: "POST",
                body: new URLSearchParams(data)
            }).then(v => {
                if (v.redirected) window.location = "http://localhost:3000/list"
            })
                .catch(e => console.warn(e))
        }
    }

    handleError = (field, errmsg) => {
        if (!field) return;

        if (errmsg) {
            this.setState((prevState) => ({
                failure: '',
                errcount: prevState.errcount + 1,
                errmsgs: { ...prevState.errmsgs, [field]: errmsg }
            }))
        } else {
            this.setState((prevState) => ({
                failure: '',
                errcount: prevState.errcount === 1 ? 0 : prevState.errcount - 1,
                errmsgs: { ...prevState.errmsgs, [field]: '' }
            }))
        }
    }

    render() {
        return (
            <div className="container">
                <Content myUsernameProp={this.state.username} myPasswordProp={this.state.password}
                    mySubmitProp={this.handleSubmit} myChangeProp={this.handleChange}
                    myValidationProp={this.validateForm} myErrorProp={this.handleError} />
            </div>
        );
    }
}

class Content extends React.Component {
    render() {
        const params = new URLSearchParams(window.location.search)
        return (
            <div className="Login">
                <Navbar inverse={true}>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <a href="#home">PT. XYZ - RMS</a>
                        </Navbar.Brand>
                    </Navbar.Header>
                </Navbar>
                <form error={params.get('error')} onSubmit={this.props.mySubmitProp}>
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
                        bsStyle="primary"
                        block
                        bsSize="large"
                        disabled={!this.props.myValidationProp}
                        type="submit">
                        Login
                </Button>
                </form>
            </div>
        );
    }
}

export default Login;