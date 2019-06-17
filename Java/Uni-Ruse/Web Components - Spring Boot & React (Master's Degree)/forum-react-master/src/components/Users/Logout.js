import React from 'react'
import Auth from '../../services/Auth'
import { Redirect } from 'react-router-dom'

const Logout = () => {
  Auth.removeToken()
  return (<Redirect to='/' />)
}

export default Logout
