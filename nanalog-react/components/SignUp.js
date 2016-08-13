import React, {Component, PropTypes} from 'react';
import SkyLight from 'react-skylight'

export default class SignUp extends Component {
    constructor(props) {
      super(props)
      this.showSignUpPopup = this.showSignUpPopup.bind(this)
    }
    showSignUpPopup(){
      this.refs.signupPopup.show();

    }
    render() {
        return (
          <div >
            <img className="logo"
                 src={require('../images/nav-item.png')}
                 onClick={this.showSignUpPopup}/>

                 <SkyLight className = "signupPopup" ref="signupPopup" >
                    <ul>
                    <li><h3>회원가입</h3></li>
                    <li><input type="text" ref="input"/></li>
                    <li><input type="text" ref="input"/></li>
                    <li><input type="text" ref="input"/></li>
                    <li><button>확인</button></li>
                    </ul>
                  </SkyLight>
          </div>
        )
    }
}
