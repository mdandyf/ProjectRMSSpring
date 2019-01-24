import { API_BASE_URL, REST_API_URL, ACCESS_TOKEN } from './constants';

const request = (options) => {

    var dataLogin = new Buffer(options.accessToken).toString("base64");
    var myHeaders = new Headers({
        Authorization: `Basic ${dataLogin}`
    });

    myHeaders.append('Content-type', 'text/html');
    options = new Object({}, {headers: myHeaders}, options)
    return fetch(options.url, options)
        .then(response =>
            response.json().then(json => {
                console.log(json);
                if (!response.ok) {
                    return Promise.reject(json);
                }
                return json;
            })
        )
};


export function getCurrentUser() {
    if (!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    var accessToken = localStorage.getItem(ACCESS_TOKEN);
    if(accessToken !== undefined) {
        console.log(accessToken);
        var currentUser = new Buffer(accessToken, 'base64').toString();
        console.log(currentUser);
        var user = currentUser.substring(0, currentUser.indexOf(":")-1);
    }

    return request({
        url: API_BASE_URL + REST_API_URL + "list/user/{" + user + "}",
        method: 'GET',
        accessToken: accessToken
    });
}


export function getLogin(loginRequest) {

    var options = {
        url: API_BASE_URL + REST_API_URL + "auth",
        method: 'GET'
    }

    var dataLogin = new Buffer(loginRequest).toString("base64");
    var myHeaders = new Headers({
        Authorization: `Basic ${dataLogin}`
    });

    myHeaders.append('Content-type', 'text/html');
    return fetch(options.url, {
        method: options.method,
        headers: myHeaders
    });
}