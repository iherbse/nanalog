import React, {Component, PropTypes} from 'react';

class Indicator extends Component {

    render() {
        return (
              <div className="diary-indicator">
                <ul>
                  <li><img src={require('../images/indicator_up.svg')} className="indicator_up"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_1"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_2"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_3"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_4"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_5"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_6"></img></li>
                  <li><img src={require('../images/indicator_unfilled.svg')} className="indicator_7"></img></li>
                  <li><img src={require('../images/indicator_down.svg')} className="indicator_down"></img></li>
                </ul>
              </div>
        )
    };

}

export default Indicator;
