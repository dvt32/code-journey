import React, { Component } from 'react'
import DateFormat from '../DateFormat'

class ReplyItem extends Component {
  render () {
    let { reply } = this.props
    return (
      <div className='row' style={{ padding: '10px' }}>
        <div className='col-4'>
          {reply.replyContent}
        </div>
        <div className='col-3'>
          <DateFormat date={reply.createdOn} />
        </div>
        <div className='col-3'>
          <DateFormat date={reply.modifiedOn} />
        </div>
      </div>
    )
  }
}

export default ReplyItem
