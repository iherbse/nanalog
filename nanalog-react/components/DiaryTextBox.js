import React, {Component, PropTypes} from 'react';

function today() {

    var date = new Date();

    var year = date.getFullYear();
    var month = date.getMonth() + 1; // 0부터 시작하므로 1더함 더함
    var day = date.getDate();

    if (("" + month).length == 1) {
        month = "0" + month;
    }
    if (("" + day).length == 1) {
        day = "0" + day;
    }

    return year + "." + month + "." + day;
}

class DiaryTextBox extends Component {

    render() {
        return (
            <div className="diary-textbox">
                <span className="diary_created_date">{today()}</span>
                <img src={require('../images/btn_current_time.svg')} className="btn_current_time"></img>
                <img src={require('../images/btn_trash.svg')} className="btn_trash"></img>
                <input type="text" className="diary_title" disabled placeholder="오늘 하루"></input>
                <hr className="seperate_title_contents"></hr>
                <textarea className="diary_contents" disabled placeholder="어떤 것을 남기고 싶나요?"></textarea>
                <div className="btn_diary_edit">편집</div>

                <div className="ui small modal">
                    <div className="header">
                        정말 일기를 삭제하시겠습니까?
                    </div>
                    <div className="actions">
                        <div className="negative ui button">삭제</div>
                        <div className="ui cancel button">취소</div>
                    </div>
                </div>
            </div>
        )
    };

}

export default DiaryTextBox;
