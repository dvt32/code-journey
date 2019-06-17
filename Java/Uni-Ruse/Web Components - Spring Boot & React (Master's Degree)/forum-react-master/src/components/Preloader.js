import React, { Component } from 'react'

export default (WrappedComponent) => {
  return class extends Component {
    constructor (props) {
      super(props)
      this._isMounted = false
      this.state = {
        data: [],
        ready: false
      }
    }

    componentDidMount () {
      this._isMounted = true
      this.props.request
        .then(res => {
          if (this._isMounted) {
            this.setState({
              data: res.data,
              ready: true
            })
          }
        })
    }
    componentWillUnmount () {
      this._isMounted = false
    }

    render () {
      if (this.state.ready) {
        return (<WrappedComponent
          data={this.state.data} {...this.props} />)
      } else {
        return (<div>Loading...</div>)
      }
    }
  }
}
