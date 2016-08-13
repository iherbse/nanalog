import React, {Component, PropTypes} from 'react';
import {render} from 'react-dom';
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import NavBar from './NavBar/NavBar';
import SideBar from './SideBar/SideBar';

class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {children} = this.props

        return (
            <div id="wrap-content">
                <NavBar/>
                <div id="side-content"></div>
                <main id="main-content">
                    <SideBar/>

                    {children}

                </main>
            </div>
        )
    }
}
function mapStateToProps(state, ownProps) {
    return {}
}
export default connect(mapStateToProps)(App)

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}
