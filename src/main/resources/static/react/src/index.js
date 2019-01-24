import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";
import Home from './jsx/App-login.jsx';
import Login from './jsx/App-login.jsx';
import List from './jsx/App-list.jsx';
import Form from './jsx/App-form.jsx';
import * as serviceWorker from './js/serviceWorker';

ReactDOM.render((
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

), document.getElementById('app'))

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
