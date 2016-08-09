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
            <div className="ui labeled button" >
                <div className="ui button">
                    <i className="heart icon"></i>
                    Like
                </div>
                <a className="ui basic label">
                    2,048
                </a>
            </div>

        )
    }
}

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}

export default App;
