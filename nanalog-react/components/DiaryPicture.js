import React, {Component, PropTypes} from 'react';

class DiaryPicture extends Component {

    render() {
        return (
            <div className="diary-picture">
                <img src={require('../images/empty_img.svg')} className="current_diary_image"></img>
                <img src={require('../images/btn_img_add.svg')} className="btn_img_add"></img>
            </div>
        )
    }
}
export default DiaryPicture;
