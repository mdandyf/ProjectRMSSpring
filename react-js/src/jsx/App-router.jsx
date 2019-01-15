import React from 'react';
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";
import Home from './App-login.jsx';
import Login from './App-login.jsx';
import List from './App-list.jsx';
import Form from './App-form.jsx';


class Routing extends React.Component {
    render() {
        return(
            <Router>
            <div>
                <Route exact path="/" render={() => (
                    <Redirect to="/home"/>
                )}/>
                <Route path="/login" component={Login} />
                <Route path="/home" component={Home} />
                <Route path="/list" component={List} />
                <Route path="/form" component={Form} />
            </div>
        </Router>
        );
    }
}

export default Routing;