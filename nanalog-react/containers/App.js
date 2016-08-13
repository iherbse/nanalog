import React, {Component, PropTypes} from 'react';
import {render} from 'react-dom';
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import NavBar from './NavBar/NavBar';
import SideBar from './SideBar/SideBar';

export default class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {children} = this.props

        return (

            <div id="wrap-content">

                <NavBar/>
                <SideBar/>
                <main id="main-content">
                    {children}
                </main>

            </div>

        )
    }
}

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}
