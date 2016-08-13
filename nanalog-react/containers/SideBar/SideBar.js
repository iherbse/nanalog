import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
// import $ from 'jquery';

class SideBar extends Component {

    render() {
        return (
            <div className="side">
                <div className="month_btn">
                    <Link to="/" href="#">
                        <img src={require('../../images/nav-item.png')}/>
                    </Link>
                </div>
                <div className="week_btn">
                    <Link to="/" href="#">
                        <img src={require('../../images/nav-item.png')}/>
                    </Link>
                </div>

            </div>

        )
    };

}

export default SideBar;
