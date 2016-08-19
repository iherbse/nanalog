import React, {Component, PropTypes} from 'react';
import DiaryTextBox from '../components/DiaryTextBox'
import DiaryPicture from '../components/DiaryPicture'
import WeeklyIndicator from '../components/WeeklyIndicator'
import Indicator from '../components/Indicator'

class WeeklyPage extends Component {

    render() {
        return (
            <div className="weekly-diary-main">
                <DiaryTextBox/>
                <DiaryPicture/>
                <Indicator/>
            </div>
        )
    };

}

export default WeeklyPage;
