import React, { Component } from 'react'
import Preloader from '../Preloader'

class TopicInfo extends Component {
  render () {
    return (<h1>{this.props.data.title}</h1>)
  }
}

export default Preloader(TopicInfo)
