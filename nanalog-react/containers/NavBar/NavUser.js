import React, {Component, PropTypes} from 'react';
import SignUp from '../../components/SignUp'

export default class NavUser extends Component {
    renderNavUser() {
      // 로그인 되어있으면 마이페이지를 볼 수 있는 Component
      // 기본은 로그인이겠지요?
      // 우선..
      return(
        <SignUp/>
      )
    }
    render() {
        return (
          <div >
          {this.renderNavUser()}
          </div>
        )
    }
}
