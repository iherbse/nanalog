import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
import { browserHistory } from 'react-router';
import moment from 'moment';


class SideBar extends Component {
    constructor(props) {
      super(props)
      this.goToWeeklyPage = this.goToWeeklyPage.bind(this)
    }

    goToWeeklyPage(){
      var today = moment().format('YYYYMMDD');
        browserHistory.push(`/WeeklyPage/${today}`)
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
                        <div className="week_2" id="week" onClick={this.goToWeeklyPage}>
                         </div>
                    </li>
                </ul>
            </div>

        )
    };

}

export default SideBar;
