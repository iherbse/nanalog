import React, {Component, PropTypes} from 'react';
import MonthlyLogInfo from '../components/MonthlyLogInfo'
import Calendar from '../components/Calendar';
import moment from 'moment';
import 'moment/locale/nb';

class MonthlyPage extends Component {

  componentWillMount() {
    this.state = {
     date: moment()
      }
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
                        onPickDate={(date) => console.log(date)}
                      />
              </div>
            </div>
          </div>
        )
    }
}
export default MonthlyPage;
