import React, {Component, PropTypes} from 'react'
import {connect} from 'react-redux'
import {browserHistory} from 'react-router'


class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {children} = this.props

        return (
            <button className="ui button">
                follow
            </button>
        )
    }
}

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}

export default App;
