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
                <div className="mypage">
                    <div className="ui dropdown">
                        <input type="hidden" name="gender"/>
                        <div className="default"><img src={require('../../images/btn_mypage.svg')}/></div>
                        <div className="menu">
                            <div className="item" data-value="Setting">Setting</div>
                            <div className="item" data-value="Logout">Log out</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    };

}

export default NavBar;
