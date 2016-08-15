import React, {Component, PropTypes} from 'react';
import uniqueId from 'lodash/uniqueId';

function getDay(day) {
    return   <div className="column">{day}</div>
}

class MonthlyCalendar extends Component {
    constructor(props) {
        super(props)
        var firstDate = 1
        var date = new Date(props.year, props.month + 1, 0);
        var lastDate = date.getDate();
        const monthDateDay = [];
        for (var i = 0; i <= lastDate; i++) {
            var day = new Date(props.year, props.month, i);
            monthDateDay.push(day.getDate());

        }
        this.state = {
            monthArray: [
                'JAN',
                'FEB',
                'MAR',
                'APR',
                'MAY',
                'JUN',
                'JUL',
                'AUG',
                'SEP',
                'OCT',
                'NOV',
                'DEC'
            ],
            dayArray: [
                'MON',
                'TUE',
                'WED',
                'THU',
                'FRI',
                'SAT',
                'SUN'
            ],
            firstDate: firstDate,
            lastDate: lastDate,
            monthDateDay: monthDateDay
        }
    }
    render() {
        return (
            <div className="diary-monthly-calendar">
                <p className="text-monthly-calendar-year">{this.props.year}</p>

                <div className="diary-monthly-calendar-table-container">
                    <div className="ui twelve column grid">
                        {this.state.monthArray.map(getDay)}
                    </div>
                    <div className="ui seven column grid">
                        <div className="row">
                            {this.state.dayArray.map(getDay)}
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}
MonthlyCalendar.propTypes = {
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
    date: PropTypes.number.isRequired
}

export default MonthlyCalendar;
