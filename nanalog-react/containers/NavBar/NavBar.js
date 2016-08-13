import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';

class NavBar extends Component {

    render() {
        return (
          <div>
              <div className="nav">
                  <Link to="/" href="#" className="nav item">
                      <img className="logo" src={require('../../images/logo.png')}/>
                  </Link>
              </div>
          </div>
        )
    }
}

export default NavBar;
