import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
// import $ from 'jquery';

class NavBar extends Component {

    render() {
        return (
            <div className="nav">
                <Link to="/" href="#">
                    <img src={require('../../images/logo.svg')} className="logo"/>
                </Link>
                <Link to="/" href="#">
                    <img src={require('../../images/btn_mypage.svg')} className="mypage"/>
                </Link>
            </div>
        )
    };

}

export default NavBar;
