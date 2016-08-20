import React, {Component, PropTypes} from 'react';
import DiaryTextBox from '../components/DiaryTextBox'
import DiaryPicture from '../components/DiaryPicture'
import Indicator from '../components/Indicator'
import { fetchPage } from '../actions/diary'
import { connect } from 'react-redux'



function loadPage(props) {
  const { pageId } = props
  props.fetchPage(pageId)
}

class WeeklyPage extends Component {
  componentWillMount() {
     loadPage(this.props)
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.text !== this.props.text) {
      loadPage(nextProps)
    }
  }
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
function mapStateToProps(state, ownProps) {
  const { pageId } = ownProps.params
  return {
    pageId : pageId
  }
}

export default connect(mapStateToProps,{
fetchPage
})(WeeklyPage);
