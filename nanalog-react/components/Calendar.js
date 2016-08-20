import React, { Component, PropTypes } from 'react';
import moment from 'moment';
import createDateObjects from './createDateObjects';
import CalendarDate from './CalendarDate';

function getMonth(month) {
    return (
      <div className="column">
        <div className="Calendar-day-item"> {month}</div>
      </div>
    )
}
function getDay(day) {
  return (
    <div className="column">
      <div className="Calendar-day-item"> {day}</div>
    </div>
  )
}
function renderDate(day,i,props){
  if(day.classNames !== null){
    return(
      <CalendarDate
      key={`day-${i}`}
      onPickDate = {props.onPickDate}
      pageId = {day.pageId}
      day = {day.day}/>

    )
  }else{
    return(
      <div
        key={`day-${i}`}
        className={`Calendar-grid-item {day.classNames}`}
        onClick={(e) => onPickDate({day})}
      >
      {renderDay(day.day)}
    </div>
    )
  }
}
export default class Calendar extends Component {
  constructor(props) {
      super(props)
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
          ]
      }
  }
  render() {
    const { date, weekOffset, renderDay, onNextMonth, onPrevMonth, onPickDate,pageList } = this.props;
    return (
      <div className='Calendar'>
        <div className='Calendar-header'>

        <div className= 'Calendar-indicator'>
          <div className='ui three column grid'>
          <img className="laquo"
              src={require('../images/btn-prev.svg')}
              onClick={onPrevMonth}/>
          <div className='Calendar-header-currentDate'>{date.format('YYYY')}</div>
          <img className="laquo"
              src={require('../images/btn-prev.svg')}
              onClick={onNextMonth}/>
          </div>
        </div>

        <div className="ui twelve column grid">
            {this.state.monthArray.map(getMonth)}
        </div>
        <div className="ui seven column grid">
            <div className="row">
                {this.state.dayArray.map(getDay)}
            </div>
        </div>
        </div>
        <div className='Calendar-grid'>
        <div className = 'ui seven column grid'>
          {createDateObjects(date, weekOffset,pageList).map((day, i) =>
            renderDate(day,i,this.props)
          )}
        </div>
        </div>
      </div>
    );
  }
}
Calendar.defaultProps = {
  weekOffset: 0,
  renderDay: day => day.format('D')
}
Calendar.propTypes = {
  weekOffset: PropTypes.number.isRequired,
  date: PropTypes.object.isRequired,
  renderDay: PropTypes.func,
  pageList : PropTypes.object,
  onNextMonth: PropTypes.func.isRequired,
  onPrevMonth: PropTypes.func.isRequired,
  onPickDate: PropTypes.func.isRequired
}
