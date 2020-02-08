import React, { Component } from 'react';
import './Counter.css';
import PropTypes from 'prop-types';

class Counter
  extends Component 
{
  constructor() {
    super();
    this.state = {
      counter: 0
    }
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.reset = this.reset.bind(this);
  }

  render() {
    return (
      <div className="counter">
        <CounterButton by={1} incrementMethod={this.increment} decrementMethod={this.decrement} />
        <CounterButton by={5} incrementMethod={this.increment} decrementMethod={this.decrement} />
        <CounterButton by={10} incrementMethod={this.increment} decrementMethod={this.decrement} />
        <span className="count">{this.state.counter}</span>
        <div>
          <button className="reset" onClick={this.reset}>Reset</button>
        </div>
      </div>
    );
  }

  reset() {
    this.setState(
      { counter: 0 }
    );
  }

  increment(by) {
    this.setState(
      (previousState) => {
        return { 
          counter: previousState.counter + by 
        }
      }
    );
  }

  decrement(by) {
    this.setState(
      (previousState) => {
        return { 
          counter: previousState.counter - by 
        }
      }
    );
  }
}

class CounterButton
  extends Component 
{

  // constructor() {
  //   super();

  //   // this.state = {
  //   //   counter: 0
  //   // }
  //   // this.increment = this.increment.bind(this); // Note: there is no need for binding when you use arrow functions for functions below
  //   // this.decrement = this.decrement.bind(this);
  // }

  render() {
    // const style = { fontSize: "50px", padding: "15px 30px" };
    return (
      <div className="counter">
        <button onClick={ () => this.props.incrementMethod(this.props.by) }>
          +{this.props.by}
        </button>
        <button onClick={ () => this.props.decrementMethod(this.props.by) }>
          -{this.props.by}
        </button>
        
        {/* <span 
          className="count"
          //style={style}
        >
          {this.state.counter}
        </span> */}
      </div>
    );
  }

  // increment() {
  //   // this.state.counter++; -> bad practice
  //   this.setState(
  //     {
  //       counter: this.state.counter + this.props.by
  //     }
  //   );
  //   this.props.incrementMethod(this.props.by);
  // }

  // decrement() {
  //   this.setState(
  //     {
  //       counter: this.state.counter - this.props.by
  //     }
  //   );
  //   this.props.decrementMethod(this.props.by);
  // }

}

CounterButton.defaultProps = {
  by: 1
};

CounterButton.propTypes = {
  by: PropTypes.number
};

export default Counter;