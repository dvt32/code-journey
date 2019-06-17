import React, { Component } from 'react'
import Api from '../../services/Api'

class AddReplyPage extends Component {
  constructor (props) {
    super(props)

    this.state = {
      content: ''
    }
    this.handleOnChange = this.handleOnChange.bind(this)
    this.handleOnSumbit = this.handleOnSumbit.bind(this)
    this.validate = this.validate.bind(this)
  }

  validate () {
    let { content } = this.state
    if (content.length < 3) {
      this.setState({ error: 'Title must be more than 3 symbols!' })
      return false
    } else {
      this.setState({ error: '' })
      return true
    }
  }

  handleOnSumbit (event) {
    event.preventDefault()
    if (this.validate()) {
      let { topicId } = this.props.match.params
      //console.log(topicId)
      const reply = {
        replyContent: this.state.content,
        topicId
      }
      reply.topicId = topicId
      Api.setInterseptor(this.props).createReply(reply)
        .then(() => {
          this.props.history.push('/topics/' + topicId)
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
        <h1>Reply Form</h1>
        <form onSubmit={this.handleOnSumbit}>
          <div className='form-group'>
            <label htmlFor='content'>Title</label>
            <input type='text'
              className='form-control'
              id='content'
              name='content'
              value={this.state.content}
              onChange={this.handleOnChange} />
            {this.state.error &&
              <small id='errorTitle' className='form-text text-muted'>{this.state.error}</small>}
          </div>
          <input type='submit' className='btn btn-primary' />
        </form>
      </div>
    )
  }
}

export default AddReplyPage
