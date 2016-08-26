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
                <input type="text" className="diary_title" disabled placeholder="제목을 입력하세요"></input>
                <hr className="seperate_title_contents"></hr>
                <textarea className="diary_contents" disabled placeholder="작가님, 커피 한 잔에 글 쓰기 좋은 저녁이네요.
이렇게 글자를 입력하고 드래그하면 메뉴를 더 볼 수 있어요."></textarea>
                <div className="btn_diary_edit"></div>

                <div className="ui small modal">
                    <i className="close icon"></i>
                    <div className="header">
                        정말 일기를 삭제하시겠습니까?
                    </div>

                    <div className="actions">
                        <div className="negative ui button">삭제</div>
                        <div className="ui button">취소</div>
                    </div>
                </div>
            </div>
        )
    };

}

export default DiaryTextBox;
