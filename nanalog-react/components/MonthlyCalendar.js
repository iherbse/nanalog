import React, {Component, PropTypes} from 'react';
import MonthlyDate from './MonthlyDate'

function getDay(day) {
    return <div className="column">{day}</div>
}
function getDate(value,index) {
    return <MonthlyDate date = {value*7+index}/>
}
function getDateDiv(index) {
  var index2 = index;
  var day = [index,index,index,index,index,index,index];
    return (<div className="ui seven column grid">
              {day.map(getDate)}
            </div>)
}

class MonthlyCalendar extends Component {
    constructor(props) {
        super(props)
        var firstDate = new Date(props.year, props.month-1, 1);
        var lastMonth = new Date(props.year, props.month, 0);
        var lastMonthDate = lastMonth.getDate();
        var firstDay = firstDate.getDay();
        var date = new Date(props.year, props.month, 0);
        var lastDate = date.getDate();
        var weekRow = [];
        var dateList = new Map();

        // 1일이 금요일 && 총 31일
        if(firstDay === 5 && lastDate === 31){
          weekRow = [0,1,2,3,4,5];
        // 1일이 토요일
        }else if(firstDay === 6){
          weekRow = [0,1,2,3,4,5];
        }else{
          weekRow = [0,1,2,3,4];
        }

        if(firstDay !== 0){
          var lastDate = (lastMonthDate+1)-firstDay;
          for (var i = 0; i< firstDay; i++, lastMonthDate++){
            dateList.push(lastMonthDate);
          }
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
            weekRow : weekRow,
            firstDay: firstDay,
            lastDate : lastDate
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
                    <div className="diary-monthly-week-container">
                            {this.state.weekRow.map(getDateDiv)}
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
