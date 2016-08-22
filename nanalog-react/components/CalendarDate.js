import React, {Component, PropTypes} from 'react';
import { browserHistory } from 'react-router'

function getDay(day) {
  return (
    <div className="column">
      <div className="Calendar-day-item"><div> {day}</div></div>
    </div>
  )
}

class CalendarDate extends Component {
  constructor(props) {
      super(props)
      this.goToWeeklyPage = this.goToWeeklyPage.bind(this)

  }
  // date칸을 눌렀을 때 click event function
  // pageId가 있는 경우 => 일기 씀 => /WeeklyPage/${this.props.pageId} (보는 창, 이 보는 창 component에서는 pageId로 getPage를 호출해서
  // page의 data를 얻고 일기를 보여줄 듯. )
  // pageId가 없는 경우 => 일기 안씀 => /WeeklyPage/ (작성 창)
  goToWeeklyPage(){
    if(this.props.pageId){
      browserHistory.push(`/WeeklyPage/${this.props.pageId}`)
    }else{
      browserHistory.push(`/WeeklyPage/`)
    }

  }
    render() {
      // pageId가 있는 경우 => 일기 씀 => 노란 칸
      // pageId가 없는 경우 => 일기 안씀 => 기본 칸
      const {pageId} = this.props;
      console.log(pageId);
      if(pageId === -1){
        return(
            <div
              key={`day-${this.props.key}`}
              className= 'Calendar-grid-item-unwrite'
              pageId = {`page-item ${this.props.pageId ||''}`}>
            {getDay(' ')}
          </div>
        )
      }else{
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
}

CalendarDate.propTypes = {
  key : PropTypes.number,
  pageId : PropTypes.string,
  day :PropTypes.object.isRequired
}
export default CalendarDate;
