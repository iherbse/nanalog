import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
import { browserHistory } from 'react-router';
import moment from 'moment';

 function today(){

        var date = new Date();

        var year  = date.getFullYear();
        var month = date.getMonth() + 1; // 0부터 시작하므로 1더함 더함
        var day   = date.getDate();

        if (("" + month).length == 1) { month = "0" + month; }
        if (("" + day).length   == 1) { day   = "0" + day;   }

        return year+""+month+""+day;
    }

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
                            <img src={require('../../images/btn-month.svg')}className="month"/>
                        </Link>
                    </li>
                    <li>
                         <img src={require('../../images/btn-week.svg')} onClick={this.goToWeeklyPage} className="week"/>
                    </li>
                </ul>
            </div>

        )
    };

}

export default SideBar;
