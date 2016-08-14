import React, {Component, PropTypes} from 'react';
import MonthlyLogInfo from '../components/MonthlyLogInfo'

class MonthlyPage extends Component {
    render() {
        return (
          <div >
            <div className="main-diary-monthly">
              <div className="diary-monthly">
                <MonthlyLogInfo/>
              </div>
            </div>
          </div>
        )
    }
}
export default MonthlyPage;
