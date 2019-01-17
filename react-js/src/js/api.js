import { API_BASE_URL, REST_API_URL, ACCESS_TOKEN } from './constants';

const request = (options) => {
    const headers = {
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + options.head,
        'credentials' : 'same-origin'  
    }

    const defaults = {headers: JSON.stringify(headers)};

    options = Object.assign({}, defaults, options);

    console.log(options.url, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    ).catch(error => console.log(error));
};

export function getCurrentUser(id) {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + REST_API_URL + "list/user/{" + id + "}",
        method: 'GET'
    });
}

export function getLogin(loginRequest) {
    return request({
        url: API_BASE_URL + REST_API_URL + "auth",
        method: 'GET',
        head: new Buffer(loginRequest).toString("base64")
    });
}