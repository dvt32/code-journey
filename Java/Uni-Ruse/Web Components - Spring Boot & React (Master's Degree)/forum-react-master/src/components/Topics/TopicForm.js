import React, { Component } from 'react'
import '../../test.css'
import Api from '../../services/Api'

class TopicForm extends Component {
  constructor (props) {
    super(props)

    this.state = {
      title: '',
      content: ''
    }
    this.handleOnChange = this.handleOnChange.bind(this)
    this.handleOnSumbit = this.handleOnSumbit.bind(this)
    this.validate = this.validate.bind(this)
  }

  validate () {
    let { title } = this.state
    if (title.length < 3) {
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
      const topic = {
        title: this.state.title,
        replyContent: this.state.content
      }
      Api.setInterseptor(this.props).postTopic(topic)
        .then(() => {
          this.props.history.push('/topics')
        })
        .catch(error => console.log(error))
    }
  }

  handleOnChange (event) {
    let { name, value } = event.target
    this.setState({ [name]: value })
  }

  render () {
    return (
      <div>
        <h1>Topic Form</h1>
        <form onSubmit={this.handleOnSumbit}>
          <div className='form-group'>
            <label htmlFor='title'>Title</label>
            <input type='text'
              className='form-control'
              id='title'
              name='title'
              value={this.state.title}
              onChange={this.handleOnChange} />
            {this.state.error &&
              <small id='errorTitle' className='form-text text-muted'>{this.state.error}</small>}
          </div>
          <div className='form-group'>
            <label htmlFor='content'>Content</label>
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

export default TopicForm
