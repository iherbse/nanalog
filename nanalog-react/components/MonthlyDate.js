import React, {Component, PropTypes} from 'react';

class MonthlyDate extends Component {

    render() {
      const {date} = this.props;
        return (
              <div className="column">{date}</div>
        )
    };

}

MonthlyDate.PropTypes = {
  pageid : PropTypes.string,
  date : PropTypes.number
}

export default MonthlyDate;
