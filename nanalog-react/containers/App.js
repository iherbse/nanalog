import React, {Component, PropTypes} from 'react';
import {render} from 'react-dom';
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';

import {
  NavBar,
  Footer,
} from '.';

const styles = require('./testStyle.js');

export default class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {children} = this.props

        return (
          <div id="full-screen" className="fullscreen pushable">
              <div id="main-app" className="main-app pusher">
                  <div id="wrap-content">
                    <NavBar/>
                      <main id="main-content">
                          {children}
                      </main>
                  </div>
              </div>
          </div>
        )
    }
}

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}
