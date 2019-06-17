import React from 'react'
import { Route, Redirect } from 'react-router-dom'
import Auth from '../services/Auth'

const PrivateRoute = ({ component: Component, ...rest }) => {
  if (Auth.isAuthenticate()) {
    return (<Route {...rest} render={(props) => <Component {...props} />} />)
  } else {
    return <Redirect to='/' />
  }
}

export default PrivateRoute
