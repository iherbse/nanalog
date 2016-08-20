import React, {Component, PropTypes} from 'react';
function getDay(day) {
  return (
    <div className="column">
      <div className="Calendar-day-item"> {day}</div>
    </div>
  )
}
class CalendarDate extends Component {

    render() {
        return (
          <div
            key={`day-${this.props.key}`}
            className= 'Calendar-grid-item'
            onClick={(e) => {this.props.onPickDate(this.props.pageId)}}
            pageId = {`page-item ${this.props.pageId ||''}`}>
          {getDay(this.props.day.format('D'))}
        </div>
        )
    }
}

CalendarDate.propTypes = {
  key : PropTypes.number,
  pageId : PropTypes.string,
  onPickDate: PropTypes.func,
  day :PropTypes.object.isRequired
}
export default CalendarDate;
