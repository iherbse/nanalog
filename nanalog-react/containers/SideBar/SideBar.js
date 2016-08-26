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
                            <div className="month_1" id="month"></div>
                        </Link>
                    </li>
                    <li>
                        <Link to="/WeeklyPage" href="#">
                          <div className="week_2" id="week"></div>
                        </Link>
                    </li>
                </ul>
            </div>

        )
    };

}

export default SideBar;
