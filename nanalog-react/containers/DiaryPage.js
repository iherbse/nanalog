import React, {Component, PropTypes} from 'react';
import DiaryTextBox from './components/DiaryTextBox'
import DiaryPicture from './components/DiaryPicture'
import WeeklyIndicator from './components/WeeklyIndicator'

class DiaryPage extends Component {

    render() {
        return (
            <div className="main-content-item">
              <div className="diarypage">
                  <DiaryTextBox/>
                  <DiaryPicture/>
                  <WeeklyIndicator/>
              </div>

            </div>

        )
    };

}

export default DiaryPage;
