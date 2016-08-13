import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
// import $ from 'jquery';

class NavBar extends Component {

    render() {
        return (
<<<<<<< HEAD
            <div className="nav">
                <Link to="/" href="#" className="item">
                    <img className="logo" src={require('../../images/logo.png')}/>
                </Link>
                <Link to="/" href="#" className="item_test">
                    <img className="logo" src={require('../../images/nav-item.png')}/>
                </Link>
            </div>

=======
          <div>
              <div className="nav">
                  <Link to="/" href="#" className="nav item">
                      <img className="logo" src={require('../../images/logo.png')}/>
                  </Link>
              </div>
          </div>
>>>>>>> 79dfe9d188abf3eeb024657d837d2f6dbec494fc
        )
    };

}

export default NavBar;
