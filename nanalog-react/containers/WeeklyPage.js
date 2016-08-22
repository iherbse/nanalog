import React, {Component, PropTypes} from 'react';
import DiaryTextBox from '../components/DiaryTextBox'
import DiaryPicture from '../components/DiaryPicture'
import Indicator from '../components/Indicator'
import { fetchPage, fetchPreviewPage } from '../actions/diary'
import { connect } from 'react-redux'
import moment from 'moment';

function loadPage(props) {
  const { pageId } = props
  props.fetchPage(pageId)
}
//fetchPreviewPage(이번주, 다음주) ->제대로 동작하는지 test필요!
function loadWeekPreviewPage(props) {
  props.fetchPreviewPage(moment().startOf('isoWeek'),moment().endOf('isoWeek'))
}

class WeeklyPage extends Component {
  //component가 mount되기 전에 date들을 load, loadWeekPreviewPage도 호출해야됨(우선 주석으로 추가!)
  componentWillMount() {
     loadPage(this.props)
     //loadWeekPreviewPage(this.props)
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.text !== this.props.text) {
      loadPage(nextProps)
      //loadWeekPreviewPage(this.props)
    }
  }
    render() {
      // Indicator에게 weekDiaryList를 prop으로 넘겨줌 (Indicator는 그 주의 pagelist의 pageid가 필요)
        return (
            <div className="weekly-diary-main">
                <DiaryTextBox/>
                <DiaryPicture/>
                <Indicator weekDiaryList = {this.props.weekDiaryList}/>
            </div>
        )
    };

}
// mapStateToProps을 통해서 store에 저장된 데이터들을 가져올 수 있음
// WeeklyPage같은 경우에는 그 날의 page의 상세정보와 Indicator에서 필요한 그 주의 page preview가 필요하기 때문에
// fetchPage, fetchPreviewPage를 하고, READ_PAGE, READ_PREVIEW_PAGE에 해당되는 data들이 store에 저장될 것(state)
function mapStateToProps(state, ownProps) {
  const { pageId } = ownProps.params
  if(state.diary !== null ){
    const { diaryComponents, pageList } = state;
    return{
      pageId : pageId,
      diaryComponents : diaryComponents,
      weekDiaryList : pageList
    }
  }else{
    return {
      pageId : pageId
    }
  }
}

export default connect(mapStateToProps,{
fetchPage,fetchPreviewPage
})(WeeklyPage);
