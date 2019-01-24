import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import Login from './App-login.jsx';
import List from './App-list.jsx';
import Form from './App-form.jsx';
import LoadingIndicator from '../js/loading';
import PrivateRoute from '../js/private';
import {notification} from 'antd';
import {getCurrentUser} from '../js/api';


class Routing extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser : "",
            isAuthenticated : false,
            isLoading : false
        }
        this.handleLogout = this.handleLogout.bind(this);
        this.loadCurrentUser = this.loadCurrentUser.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }

    loadCurrentUser() {
        this.setState({
          isLoading: true
        });
        getCurrentUser()
        .then(response => {
          this.setState({
            currentUser: response,
            isAuthenticated: true,
            isLoading: false
          });
        }).catch(error => {
          this.setState({
            isLoading: false
          });  
        });
      }
    
      componentDidMount() {
          if(this.state.isAuthenticated) {
            this.loadCurrentUser();
          }
      }

      handleLogin() {
        notification.success({
            message: 'RMS App',
            description: "You're successfully logged in.",
          });
          this.loadCurrentUser();
          this.props.history.push("/list");
      }

      handleLogout(redirectTo="/", notificationType="success", description="You're successfully logged out.") {
        this.setState({
            currentUser: null,
            isAuthenticated: false
          });
      
          this.props.history.push(redirectTo);
          
          notification[notificationType]({
            message: 'Polling App',
            description: description,
          });
      }

    render() {

        if(this.state.isLoading) {
            return <LoadingIndicator />
        }

        return(
            <BrowserRouter>
            <Switch>
                <Route exact path="/" render={() => (<Redirect to="/home"/>)}/>
                <Route path="/login" render = {(props) => <Login onLogin={this.handleLogin} {...props}/>}/>
                <Route path="/home" render = {(props) => <Login onLogin={this.handleLogin} {...props}/>}/>
                <PrivateRoute path="/list" authenticated={this.state.isAuthenticated} 
                    isAuthenticated={this.state.isAuthenticated} 
                    currentUser={this.state.currentUser} component={List}/>
                <PrivateRoute path="/form" authenticated={this.state.isAuthenticated} 
                    handleLogout={this.handleLogout} component={Form} />
            </Switch>
        </BrowserRouter>
        );
    }
}

export default Routing;