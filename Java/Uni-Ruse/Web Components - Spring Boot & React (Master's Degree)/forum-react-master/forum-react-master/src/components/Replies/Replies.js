import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import Preloader from '../Preloader'
import ReplyItem from './ReplyItem'

class Replies extends Component {
  render () {
    //console.log(this.props.data)
    const { topicId, data } = this.props
    return (<div>
      {
        data.map((reply, index) => (
          <ReplyItem key={index} reply={reply} />
        ))
      }
      <Link className='btn btn-primary'
        to={`/topics/${topicId}/add`} >
        Add Reply
      </Link>
    </div>)
  }
}

export default Preloader(Replies)
