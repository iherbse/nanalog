import React, {Component, PropTypes} from 'react';

class DiaryTextBox extends Component {

    render() {
        return (
            <div className="main-content-item">
              <div className="diary-textbox">
                <img className="ic-current-time" src={require('../images/ic_test.png')}/>
                <span className="text-current">2016.08.05 12:12AM</span>
                <img className="ic-delete" src={require('../images/ic_test.png')}/>
                <span className="text-title">사소한 것은 하나도 없다</span>
                <hr className="divider"/>
                <span className="text-content">
                  이맘때, 남한산성에 올랐다.
                  숲은 짙푸른 녹음으로 어두웠고, 숲 속엔 어렵사리 빛들이 스며들고
                  있었다.
                  뜨거운 여름날이면 흔하디 흔한 빛이 숲 속엔 드문드문 스며들어 빛이
                  비치는 곳에 머무는 것들을 아주 특별하게 만들고 있었다.
                  이맘때, 남한산성에 올랐다.
                  숲은 짙푸른 녹음으로 어두웠고, 숲 속엔 어렵사리 빛들이 스며들고
                  있었다.
                  뜨거운 여름날이면 흔하디 흔한 빛이 숲 속엔 드문드문 스며들어 빛이
                  비치는 곳에 머무는 것들을 아주 특별하게 만들고 있었다.
                </span>
                <div className="buttn-edit"><span>편집</span></div>
              </div>
            </div>

        )
    };

}

export default DiaryTextBox;
