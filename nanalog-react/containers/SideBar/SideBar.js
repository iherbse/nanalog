import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
// import $ from 'jquery';

class SideBar extends Component {

    render() {
        return (
            <div className="side">
                <ul>
                    <li>
                        <Link to="/" href="#">
                            <img src={require('../../images/nav-item.png')} className="month"/>
                        </Link>
                    </li>
                    <li>
                        <Link to="/" href="#">
                            <img src={require('../../images/nav-item.png')} className="week"/>
                        </Link>
                    </li>
                </ul>
            </div>

        )
    };

}

export default SideBar;
