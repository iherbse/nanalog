import React, {Component, PropTypes} from 'react';
import {render} from 'react-dom';
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import NavBar from './NavBar/NavBar';
import fetchPageList from '../actions/diary'

class App extends Component {
    constructor(props) {
        super(props)
        this.fetchPageList = this.fetchPageList.bind(this)
    }

    render() {
        const {children} = this.props

        return (
            <div id="wrap-content">
            <button onClick = {this.fetchPageList}>click</button>
              <NavBar/>
                <div id="side-content"></div>
                <main id="main-content">
                    {children}
                </main>
            </div>

        )
    }
}
function mapStateToProps(state, ownProps) {
  return {}
}
export default connect(mapStateToProps, fetchPageList)(App)

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
    fetchPageList: PropTypes.function
}
