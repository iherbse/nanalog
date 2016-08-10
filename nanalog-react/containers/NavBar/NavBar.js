import React, {Component, PropTypes} from 'react';
import { Link } from 'react-router';


class NavBar extends Component {

  render(){
    return (
      <div className = "nav">
        <ul>
          <li>
            <Link to="/" href="#" className="nav item">
              <img className="logo" src={require('../../images/logo.png')} />
            </Link>
          </li>
          <li>
            <Link to="/Calender" className="nav item">
              <img className="logo" src={require('../../images/nav-item.png')} />
            </Link>
          </li>
        </ul>
      </div>
    )
  }
}

export default NavBar;
