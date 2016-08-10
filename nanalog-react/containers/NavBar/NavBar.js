import React, {Component, PropTypes} from 'react';
import { Link } from 'react-router';


class NavBar extends Component {

  render(){
    return (
      <div>

        <Link to="/" href="#" className="header item">
          <img className="logo" src={require('../../images/logo.png')} style={styles.logoImage}/>
        </Link>
      </div>
    )
  }
}

const styles = {
  logoImage: {
    marginRight: '1rem',
    color: '#FF0000'
  }
};

export default NavBar;
