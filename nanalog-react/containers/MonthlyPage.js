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
    this.props.fetchPreviewPage("ss","ss")
    this.state = {
     date: moment()
    }
  }
  goWeeklyPage(){
    browserHistory.push(`/WeeklyPage/`)

  }
    render() {

        return (
          <div >
            <div className="main-diary-monthly">
              <div className="diary-monthly">
              <MonthlyLogInfo/>
                <Calendar
                        onNextMonth={() => this.setState({ date: this.state.date.clone().add(1, 'months') }) }
                        onPrevMonth={() => this.setState({ date: this.state.date.clone().subtract(1, 'months') }) }
                        date={this.state.date}
                        onPickDate={(date) => this.goWeeklyPage()}
                      />
              </div>
            </div>
          </div>
        )
    }
}
function mapStateToProps(state) {
  const { diary } = state
  console.log(diary);

  return {
  }

}
export default connect(mapStateToProps,{
  fetchPreviewPage
})(MonthlyPage);
