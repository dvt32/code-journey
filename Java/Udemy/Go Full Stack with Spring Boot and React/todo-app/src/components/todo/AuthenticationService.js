import Axios from "axios";
import { API_URL } from "../../Constants";

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';
export const USER_TOKEN_SESSION_ATTRIBUTE_NAME = 'userToken';

class AuthenticationService {
    
    executeBasicAuthenticationService(username, password) {
        let basicAuthHeader = this.createBasicAuthToken(username, password);

        return Axios.get(`${API_URL}/basicauth`, {
            headers: {
                authorization: basicAuthHeader
            }
        });
    }

    executeJwtAuthenticationService(username, password) {
        return Axios.post(`${API_URL}/authenticate`, {
            username,
            password
        });
    }

    createBasicAuthToken(username, password) {
        return "Basic " + window.btoa(username + ":" + password);
    }

    createJwtToken(token) {
        sessionStorage.setItem(USER_TOKEN_SESSION_ATTRIBUTE_NAME, "Bearer " + token);
        return "Bearer " + token;
    }

    registerSuccessfulLogin(username, password) {
        let basicAuthHeader = this.createBasicAuthToken(username, password);
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username);
        this.setupAxiosInterceptors(basicAuthHeader);
    }

    registerSuccessfulLoginForJwt(username, token) {
        let jwtToken = this.createJwtToken(token);
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username);
        this.setupAxiosInterceptors(jwtToken);
    }

    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        sessionStorage.removeItem(USER_TOKEN_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        if (user === null) {
            return false;
        }
        else {
            return true;
        }
    }

    getLoggedInUserName() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        if (user === null) {
            return '';
        }
        else {
            return user;
        }
    }

    setupAxiosInterceptors(token) {
        Axios.interceptors.request.use(
            (config) => {
                if (this.isUserLoggedIn()) {
                    config.headers.authorization = token;
                }
                return config;
            }
        );
    }

}

export default new AuthenticationService();