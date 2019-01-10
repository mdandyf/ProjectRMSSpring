import React from 'react';
import ReactDOM from 'react-dom';
import './login.css';
import Login from './App-login.jsx';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<Login />, document.getElementById('login'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
