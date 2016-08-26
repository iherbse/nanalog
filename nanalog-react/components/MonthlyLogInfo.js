import React, {Component, PropTypes} from 'react';
import { connect } from 'react-redux'


class MonthlyLogInfo extends Component {
  shouldComponentUpdate ( nextProps, nextState){
    return true;
  }


    render() {
      let pageCount = this.props.pageCount;
        return (
          <div className="diary-monthly-log-info">
            <div className="text-monthly-log-info-top-container">
              <p className="text-monthly-log-info-nickname">닉네임</p>
              <p className="text-monthly-log-info-email">jinjoooooooo@gmail.com</p>
            </div>
            <div className="text-monthly-log-info-bottom-container">
              <p className="text-monthly-log-info-log-title">이번달 로그</p>
              <p className="text-monthly-log-info-log-title">총 로그 </p>
              <p className="text-monthly-log-info-log"> {pageCount}</p>
            </div>
          </div>
        )
    };

}


export default MonthlyLogInfo;
