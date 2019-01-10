import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch, HashRouter } from "react-router-dom";
import Home from './App-login.jsx';
import Login from './App-login.jsx';
import List from './App-list.jsx';
import Form from './App-form.jsx';
import * as serviceWorker from './serviceWorker';

ReactDOM.render((

    <Router>
        <div>
            <Route path="/" Component={Home} />
            <Route path={"/login"} component={Login} />
            <Route path={"/home"} component={Home} />
            <Route path="/list" component={List} />
            <Route path="/form" component={Form} />
        </div>
    </Router>

), document.getElementById('app'))

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
