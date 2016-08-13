import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
// import $ from 'jquery';

class NavBar extends Component {

    render() {
        return (
            <div className="nav">
                <Link to="/" href="#" className="item">
                    <img className="logo" src={require('../../images/logo.png')}/>
                </Link>
                <Link to="/" href="#" className="item_test">
                    <img className="logo" src={require('../../images/nav-item.png')}/>
                </Link>
            </div>

        )
    };

}

export default NavBar;
