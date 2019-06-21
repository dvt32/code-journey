import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import Auth from '../services/Auth'
class Navbar extends Component {
  render () {
    return (
      <nav className='navbar navbar-expand-lg navbar-light bg-light'>
        <button className='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
          <span className='navbar-toggler-icon' />
        </button>
        <div className='collapse navbar-collapse' id='navbarNav'>
          <ul className='navbar-nav'>
            <li className='nav-item active'>
              <Link className='nav-link' to='/home'>Home</Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/topics'>Topics</Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/stats'>Stats</Link>
            </li>
            {Auth.isAuthenticate() && <li className='nav-item'>
              <Link className='nav-link' to='/logout'>Logout</Link>
            </li>}
          </ul>
        </div>
      </nav>
    )
  }
}

export default Navbar
