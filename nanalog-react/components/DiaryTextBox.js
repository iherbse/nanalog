import React, {Component, PropTypes} from 'react';
import {createComponent, createPage, deletePage} from '../actions/diary'
import {connect} from 'react-redux'

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

function renderTodayPage(title, content, image, today, todayPage) {
    if (typeof todayPage !== "undefined") {
        if (todayPage.length > 0) {
            return (
                <div className="diary-textbox-inner">
                    <span className="diary_created_date">{today}</span>
                    <img src={require('../images/btn_current_time.svg')} className="btn_current_time"></img>
                    <img src={require('../images/btn_trash.svg')} className="btn_trash"></img>
                    <input type="text" className="diary_title" disabled value={title}></input>
                    <hr className="seperate_title_contents"></hr>
                    <textarea className="diary_contents" disabled value={content}></textarea>
                    <div className="btn_diary_edit">편집</div>

                    <div className="ui small modal">
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
        } else {
            return (
                <div className="diary-textbox-inner">
                    <span className="diary_created_date">{today}</span>
                    <img src={require('../images/btn_current_time.svg')} className="btn_current_time"></img>
                    <img src={require('../images/btn_trash.svg')} className="btn_trash"></img>
                    <input type="text" className="diary_title" placeholder="제목을 입력하세요"></input>
                    <hr className="seperate_title_contents"></hr>
                    <textarea className="diary_contents" placeholder="어떤 것을 남기고 싶나요?"></textarea>
                    <div className="btn_diary_edit">편집</div>

                    <div className="ui small modal">
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
        }
    }
}

class DiaryTextBox extends Component {
    render() {
        const {title, content, image, today, todayPage} = this.props;
        console.log(todayPage);
        return (
            <div className="diary-textbox">
                {renderTodayPage(title, content, image, today, todayPage)}
            </div>
        )

    };

}
function mapStateToProps(state, ownProps) {
    console.log("ownProps!!");
    console.log(ownProps);
    const {todayPage} = ownProps;
    if (typeof todayPage !== "undefined") {
        var title;
        var content;
        var image;
        for (var i = 0; i < todayPage.length; i++) {
            if (todayPage[i].type == 1) {
                title = todayPage[i].body;
            } else if (todayPage[i].type == 2) {
                content = todayPage[i].body;
            } else if (todayPage[i].type == 3) {
                image = todayPage[i].body;
            }
        }
        return {title: title, content: content, image: image}
    } else {
        return {}
    }
}
DiaryTextBox.propTypes = {
    pageId: PropTypes.number,
    title: PropTypes.string,
    content: PropTypes.string,
    image: PropTypes.string,
    today: PropTypes.string
}
export default connect(mapStateToProps, {createComponent, createPage, deletePage})(DiaryTextBox);
