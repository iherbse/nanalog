import React, {Component, PropTypes} from 'react';

class CalendarDate extends Component {
    render() {

        return (
          <div className="Calendar-date-item">
            {this.props.date.toDate()}
          </div>
        )
    }
}

CalendarDate.propTypes = {
  date: PropTypes.object.isRequired,
  onPickDate: PropTypes.func
}
export default CalendarDate;
