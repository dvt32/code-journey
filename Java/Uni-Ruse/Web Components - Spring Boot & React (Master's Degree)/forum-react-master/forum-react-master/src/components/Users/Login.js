import React, { Component } from 'react'
import Api from '../../services/Api'
import Auth from '../../services/Auth'

class Login extends Component {
  constructor (props) {
    super(props)

    this.state = {
      username: '',
      password: '',
      error: {}
    }
    this.handleOnChange = this.handleOnChange.bind(this)
    this.handleOnSumbit = this.handleOnSumbit.bind(this)
    this.validate = this.validate.bind(this)
  }

  validate () {
    let { username, password } = this.state
    let error = {}
    if (username.length < 3) {
      error.username = 'Username must be more than 3 symbols!'
    }
    if (password.length < 3) {
      error.password = 'Password must be more than 3 symbols!'
    }
    this.setState(error)
    return (error !== {})
  }

  handleOnSumbit (event) {
    event.preventDefault()
    if (this.validate()) {
      let formData = new window.FormData()
      formData.append('grant_type', 'password')
      formData.append('username', this.state.username)
      formData.append('password', this.state.password)
      Api.login(formData)
        .then(({ data }) => {
          Auth.setToken(data.access_token)
          this.props.history.push('/topics')
        })
        .catch(data => {
          const error = {
            username: data.error
          }
          this.setState({ error })
        })
    }
  }

  handleOnChange (event) {
    let { name, value } = event.target
    this.setState({ [name]: value })
  }

  render () {
    return (
      <div>
        <h1>Login Form</h1>
        <form onSubmit={this.handleOnSumbit}>
          <div className='form-group'>
            <label htmlFor='username'>Username</label>
            <input type='text'
              className='form-control'
              id='username'
              name='username'
              value={this.state.username}
              onChange={this.handleOnChange} />
            {this.state.error.username &&
              <small id='errorUserName' className='form-text text-muted'>{this.state.error.username}</small>}
          </div>
          <div className='form-group'>
            <label htmlFor='password'>Password</label>
            <input type='password'
              className='form-control'
              id='password'
              name='password'
              value={this.state.password}
              onChange={this.handleOnChange} />
            {this.state.error.password &&
              <small id='errorPassword' className='form-text text-muted'>{this.state.error.password}</small>}
          </div>
          <input type='submit' className='btn btn-primary' />
        </form>
      </div>
    )
  }
}

export default Login
