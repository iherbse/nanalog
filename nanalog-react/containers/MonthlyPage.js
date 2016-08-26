import React, {Component, PropTypes} from 'react';
import MonthlyLogInfo from '../components/MonthlyLogInfo'
import Calendar from '../components/Calendar';
import { connect } from 'react-redux'
import moment from 'moment';
import 'moment/locale/nb';
import { browserHistory } from 'react-router'
import { fetchPreviewPage }from '../actions/diary'


class MonthlyPage extends Component {
  constructor(props) {
      super(props)
      this.addMonth = this.addMonth.bind(this);
      this.subtractMonth = this.subtractMonth.bind(this);
  }
  // component가 mount되기 전에 date들을 load. 이 달의 startdate와 lastdate를 구해서  YYYYMMdd format으로 넘겨줘야함.
  // moment() -> moment js의 현재시간을 구해주는 function
  componentWillMount() {
    this.props.fetchPreviewPage("startdate","lastdate")
    this.state = {
     date: moment()
    }
  }
  addMonth(index){
    console.log("addMonth!");
    this.state.date.clone().add(index,'months');
  }
  subtractMonth(index){
    this.state.date.clone().subtract(index,'months');
  }
  // MonthlyLogInfo에는 총 남긴 로그 수에 들어갈 pageCount만 prop으로 넘겨줌.
  // Calendar에는 이전달, 이번달 date, pageList를 prop으로 넘겨줌.
    render() {
        let pageCount = this.props.pageCount;
        let pageList = this.props.pageList;
        return (
          <div >
            <div className="main-diary-monthly">
              <div className="diary-monthly">
              <MonthlyLogInfo pageCount = {pageCount}/>
                <Calendar
                        addMonth = {this.addMonth}
                        subtractMonth = {this.subtractMonth}
                        onNextMonth={() => this.setState({ date: this.state.date.clone().add(1, 'months') }) }
                        onPrevMonth={() => this.setState({ date: this.state.date.clone().subtract(1, 'months') }) }
                        date={this.state.date}
                        pageList = {pageList}/>
              </div>
            </div>
          </div>
        )
    }
}
// mapStateToProps을 통해서 store에 저장된 데이터들을 가져올 수 있음
// MonthlyPage 경우에는 그 달의 page preview가 필요하기 때문에
// fetchPreviewPage를 하고 READ_PREVIEW_PAGE에 해당되는 data들이 store에 저장될 것(state)
function mapStateToProps(state) {
  if(state.diary !== null ){
    const {
      diary: { pageCount,pageList }
    } = state
    return {
      pageCount : pageCount,
      pageList : pageList
    }
  }
  console.log(state);
  return {
    pageCount : null,
    pageList : null
  }
}

export default connect(mapStateToProps,{
  fetchPreviewPage
})(MonthlyPage);
