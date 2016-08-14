import React, {Component, PropTypes} from 'react';

class MonthlyLogInfo extends Component {

    render() {
        return (
          <div className="diary-monthly-log-info">
            <p className="text-monthly-log-info-nickname">닉네임</p>
            <p className="text-monthly-log-info-email">jinjoooooooo@gmail.com</p>
            <p className="text-monthly-log-info-log-title">이번달 로그</p>
            <p className="text-monthly-log-info-log-title">총 로그 </p>
            <p className="text-monthly-log-info-log"> 12</p>
          </div>
        )
    };

}

export default MonthlyLogInfo;
