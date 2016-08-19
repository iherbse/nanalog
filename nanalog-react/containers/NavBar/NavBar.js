import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
import SkyLight from 'react-skylight'

class NavBar extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className="nav">
                <Link to="/" href="#">
                    <img src={require('../../images/logo.svg')} className="logo"/>
                </Link>
                <Link to="/" href="#">
                    <img src={require('../../images/btn_mypage.svg')} className="mypage custom button"/>
                </Link>
                <div className="ui custom popup transition hidden">
                  I'm not on the same level as the button, but i can still be found.
                </div>
            </div>
        )
    };

}

export default NavBar;
