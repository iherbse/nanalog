import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { browserHistory } from 'react-router'


class App extends Component{
  constructor(props) {
    super(props)
  }

  render(){
    const { children } = this.props

    return(
    <div>
    히익!!!!!!! 늦어서 죄송합니당
    {children}
    </div>
    )
  }
}

App.propTypes = {
  // Injected by React Redux  // Injected by React Router
  children: PropTypes.node
}

export default App;
