import React, {Component, PropTypes} from 'react';
import DiaryTextBox from '../components/DiaryTextBox'
import DiaryPicture from '../components/DiaryPicture'
import WeeklyIndicator from '../components/WeeklyIndicator'

class DiaryPage extends Component {

    render() {
        return (
            <div id="main-content-item">
              <div className="diarypage">
                  <DiaryTextBox/>
                  <DiaryPicture/>
              </div>

            </div>

        )
    };

}

export default DiaryPage;
