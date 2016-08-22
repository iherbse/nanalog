import React, {Component, PropTypes} from 'react';

class DiaryTextBox extends Component {

    render() {
        return (
            <div className="diary-textbox">
                <span className="diary_created_date">2016.08.05 12:12AM</span>
                <img src={require('../images/btn_current_time.svg')} className="btn_current_time"></img>
                <img src={require('../images/btn_trash.svg')} className="btn_trash"></img>
                <input type="text" className="diary_title" disabled placeholder="제목을 입력하세요"></input>
                <hr className="seperate_title_contents"></hr>
                <textarea className="diary_contents" disabled placeholder="작가님, 커피 한 잔에 글 쓰기 좋은 저녁이네요.
이렇게 글자를 입력하고 드래그하면 메뉴를 더 볼 수 있어요.">
                </textarea>
                <img src={require('../images/btn_diary_edit.svg')} className="btn_diary_edit"/>
            </div>
        )
    };

}

export default DiaryTextBox;
