import React, {Component, PropTypes} from 'react';
import { fetchPreviewPage } from '../actions/diary'
import { connect } from 'react-redux'
import moment from 'moment';


function getIndicator(pageList,weeklistOfPageList) {
  let return_val = [];

  for(var i=0 ; i < 7 ; i++){
    for(var j=0; j < weeklistOfPageList.length; j++){
      if(Number(weeklistOfPageList[j]) == i){
        console.log("i = "+i);
        console.log("j = "+j);
        return_val.push( <li><img src={require('../images/indicator_filled.svg')} className= {`indicator_${i}`} ></img></li> )
        break;
      }
    }
    return_val.push( <li><img src={require('../images/indicator_unfilled.svg')} className= {`indicator_${i}`}></img></li> )
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
      console.log("Indicator props");
      console.log(this.props);
      const {pageList, weeklistOfPageList} = this.props;
        return (
              <div className="diary-indicator">
                <ul>
                  <li><img src={require('../images/indicator_up.svg')} className="indicator_up"></img></li>
                  {getIndicator(pageList,weeklistOfPageList)}
                  <li><img src={require('../images/indicator_up.svg')} className="indicator_down"></img></li>
                </ul>
              </div>
        )
    };

}
function mapStateToProps(state, ownProps) {
  const {pageList} = ownProps;
  if(typeof pageList !==  "undefined"){
    var weeklistOfPageList = [];
    for(var i = 0; i < pageList.length; i++){
      var momentObj = moment(pageList[i].date, 'YYYYMMDD')
      weeklistOfPageList[i] = momentObj.day();
    }
    return{
      weeklistOfPageList : weeklistOfPageList
    }
  }
}
Indicator.propTypes = {
  pageList :PropTypes.array.isRequired,
  weeklistOfPageList : PropTypes.array

}
export default connect(mapStateToProps,{
  fetchPreviewPage
})(Indicator);
