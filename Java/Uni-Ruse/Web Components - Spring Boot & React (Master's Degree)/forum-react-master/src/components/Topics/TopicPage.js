import React, { Component } from 'react'
import Api from '../../services/Api'
import TopicInfo from './TopicInfo'
import Replies from '../Replies/Replies'

class TopicPage extends Component {
  render () {
    let { topicId } = this.props.match.params
    return (
      <div>
        <TopicInfo request={Api.setInterseptor(this.props).fetchTopicById(topicId)} />
        <Replies
          topicId={topicId}
          request={Api.setInterseptor(this.props).fetchRepliesByTopicId(topicId)} />
      </div>
    )
  }
}

export default TopicPage
