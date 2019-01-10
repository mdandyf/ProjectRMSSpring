import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import Form from './App-form.jsx';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<Form />, document.getElementById('form'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
