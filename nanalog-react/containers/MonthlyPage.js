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
      this.goWeeklyPage = this.goWeeklyPage.bind(this)
    }
  componentWillMount() {
    this.props.fetchPreviewPage("startdate","lastdate")
    this.state = {
     date: moment()
    }
  }
    render() {
        let pageCount = this.props.pageCount;
        let pageList = this.props.pageList;
        return (
          <div >
            <div className="main-diary-monthly">
              <div className="diary-monthly">
              <MonthlyLogInfo pageCount = {pageCount}/>
                <Calendar
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
