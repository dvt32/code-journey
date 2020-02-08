import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService'
import { Route, Redirect } from 'react-router-dom'

class AuthenticatedRoute 
    extends Component 
{

    componentWillMount() {
        AuthenticationService.setupAxiosInterceptors( 
            sessionStorage.getItem("userToken") 
        );
    }

    render() {
        if (AuthenticationService.isUserLoggedIn()) {
            return <Route {...this.props} />
        }
        else {
            return <Redirect to="/login" />
        }
    }
}

export default AuthenticatedRoute;