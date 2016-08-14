import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';


class SideBar extends Component {
    constructor(props) {
      super(props)
    }


    render() {
        return (
            <div className="side">
                <ul>
                    <li>
                        <Link to="/MonthlyPage" href="#">
                            <img src={require('../../images/nav-item.png')}className="month"/>
                        </Link>
                    </li>
                    <li>
                        <Link to="/WeeklyPage" href="#">
                            <img src={require('../../images/nav-item.png')} className="week"/>
                        </Link>
                    </li>
                </ul>
            </div>

        )
    };

}

export default SideBar;
