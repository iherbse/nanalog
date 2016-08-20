import React, {Component, PropTypes} from 'react';
import { browserHistory } from 'react-router'

function getDay(day) {
  return (
    <div className="column">
      <div className="Calendar-day-item"> {day}</div>
    </div>
  )
}

class CalendarDate extends Component {
  constructor(props) {
      super(props)
      this.goToWeeklyPage = this.goToWeeklyPage.bind(this)

  }
  goToWeeklyPage(){
    console.log("Asdsadsadsd");
    console.log(this.props.pageId);
    if(this.props.pageId){
      browserHistory.push(`/WeeklyPage/${this.props.pageId}`)
    }else{
      browserHistory.push(`/WeeklyPage/`)
    }

  }
    render() {
      const {pageId} = this.props;
      console.log(pageId);
      if(pageId){
        return (
          <div
            key={`day-${this.props.key}`}
            className= 'Calendar-grid-item-write'
            onClick={this.goToWeeklyPage}
            pageId = {`page-item ${this.props.pageId ||''}`}>
          {getDay(this.props.day.format('D'))}
        </div>
        )
      }else{
        return (
          <div
            key={`day-${this.props.key}`}
            className= 'Calendar-grid-item-unwrite'
            onClick={this.goToWeeklyPage}
            pageId = {`page-item ${this.props.pageId ||''}`}>
          {getDay(this.props.day.format('D'))}
        </div>
      )
      }
    }
}

CalendarDate.propTypes = {
  key : PropTypes.number,
  pageId : PropTypes.string,
  day :PropTypes.object.isRequired
}
export default CalendarDate;
