import React, { Component, PropTypes } from 'react'
import { Provider } from 'react-redux'
import routes from '../routes'
import { Router } from 'react-router'
import DevTools from '../DevTools'



export default class Root extends Component {
  render() {
    const { store, history } = this.props

    return (
      <Provider store={store}>
        <div>
        <DevTools />

          <Router history={history} routes={routes} />
        </div>
      </Provider>
    )
  }
}

Root.propTypes = {
  store : PropTypes.object.isRequired,
  history: PropTypes.object.isRequired
}
