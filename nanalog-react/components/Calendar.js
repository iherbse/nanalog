import React, { Component, PropTypes } from 'react';
import moment from 'moment';
import createDateObjects from './createDateObjects';

function getDay(day) {
    return <div className="column">{day}</div>
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
    const { date, weekOffset, renderDay, onNextMonth, onPrevMonth, onPickDate } = this.props;
    return (
      <div className='Calendar'>
        <div className='Calendar-header'>

        <div className='ui three column grid'>
          <button onClick={onPrevMonth} className="laquo">&laquo;</button>
          <div className='Calendar-header-currentDate'>{date.format('YYYY')}</div>
          <button onClick={onNextMonth} className="laquo">&raquo;</button>
        </div>

        <div className="ui twelve column grid">
            {this.state.monthArray.map(getDay)}
        </div>
        <div className="ui seven column grid">
            <div className="row">
                {this.state.dayArray.map(getDay)}
            </div>
        </div>
        </div>
        <div className='Calendar-grid'>
        <div className = 'ui seven column grid'>
          {createDateObjects(date, weekOffset).map((day, i) =>
              <div
                key={`day-${i}`}
                className={`Calendar-grid-item ${day.classNames || ''}`}
                onClick={(e) => onPickDate({day})}
                >
                {renderDay(day.day)}
              </div>
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
  onNextMonth: PropTypes.func.isRequired,
  onPrevMonth: PropTypes.func.isRequired,
  onPickDate: PropTypes.func.isRequired
}
