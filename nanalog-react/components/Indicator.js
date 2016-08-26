import React, {Component, PropTypes} from 'react';
import {fetchPreviewPage} from '../actions/diary'
import {connect} from 'react-redux'
import moment from 'moment';

function getIndicator(pageList, weeklistOfPageList, currentOfWeek) {
    let return_val = [];
    let j = 0;
    console.log(weeklistOfPageList);
    console.log(currentOfWeek);
    if (j < weeklistOfPageList.length) {
        for (var i = 1; i <= 7; i++) {
            if (weeklistOfPageList[j] == i || (weeklistOfPageList[j] == 0 && i == 7)) {
                if (currentOfWeek == i || (currentOfWeek == 0 && i == 7)) {
                    return_val.push(
                        <li>
                            <img src={require('../images/indicator_focused.svg')} className={`indicator_${i}`}></img>
                        </li>
                    )
                } else {
                    return_val.push(
                        <li>
                            <img src={require('../images/indicator_filled.svg')} className={`indicator_${i}`}></img>
                        </li>
                    )
                }
                j++;
            } else {
                if (currentOfWeek == i || (currentOfWeek == 0 && i == 7)) {
                    return_val.push(
                        <li>
                            <img src={require('../images/indicator_focused.svg')} className={`indicator_${i}`}></img>
                        </li>
                    )
                } else {
                    return_val.push(
                        <li>
                            <img src={require('../images/indicator_unfilled.svg')} className={`indicator_${i}`}></img>
                        </li>
                    )
                }
            }
        }
    }
    return (
        <div>
            {return_val}
        </div>
    )
}
class Indicator extends Component {

    //  {this.state.pageList.map(getIndicator)}

    render() {
        const {pageList, weeklistOfPageList, currentOfWeek} = this.props;
        return (
            <div className="diary-indicator">
                <ul>
                    <li>
                        <img src={require('../images/indicator_up.svg')} className="indicator_up"></img>
                    </li>
                    {getIndicator(pageList, weeklistOfPageList, currentOfWeek)}
                    <li>
                        <img src={require('../images/indicator_up.svg')} className="indicator_down"></img>
                    </li>
                </ul>
            </div>
        )
    };

}
function mapStateToProps(state, ownProps) {
    const {pageList, today} = ownProps;
    var todayObj = moment(today, 'YYYYMMDD');
    var currentOfWeek = todayObj.day();

    if (typeof pageList !== "undefined") {
        var weeklistOfPageList = [];
        for (var i = 0; i < pageList.length; i++) {
            var momentObj = moment(pageList[i].date, 'YYYYMMDD')
            weeklistOfPageList[i] = momentObj.day();
        }
        return {weeklistOfPageList: weeklistOfPageList, currentOfWeek: currentOfWeek}
    }
}
Indicator.propTypes = {
    pageList: PropTypes.array.isRequired,
    weeklistOfPageList: PropTypes.array,
    currentOfWeek: PropTypes.number

}
export default connect(mapStateToProps, {fetchPreviewPage})(Indicator);
