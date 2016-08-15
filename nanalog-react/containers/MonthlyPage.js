import React, {Component, PropTypes} from 'react';
import MonthlyLogInfo from '../components/MonthlyLogInfo'
import MonthlyCalendar from '../components/MonthlyCalendar'

class MonthlyPage extends Component {
  
  componentWillMount() {
    var date = new Date()
      this.state = {
        year : date.getFullYear(),
        month : date.getMonth(),
        date : date.getDate()
      }
  }
    render() {
        return (
          <div >
            <div className="main-diary-monthly">
              <div className="diary-monthly">
                <MonthlyLogInfo year = {this.state.year} month = {this.state.month} date = {this.state.date}/>
                <MonthlyCalendar year = {this.state.year} month = {this.state.month} date = {this.state.date}/>
              </div>
            </div>
          </div>
        )
    }
}
export default MonthlyPage;
