import React, { Component } from 'react'
import Preloader from '../Preloader'
import TopicItem from './TopicItem'

class AllTopics extends Component {
  constructor (props) {
    super(props)
    this.state = {}
  }

  render () {
    return (<div>
      {
        this.props.data.map((topic) => (
          <TopicItem key={topic.id} topic={topic} />
        ))
      }
    </div>)
  }
}

export default Preloader(AllTopics)
