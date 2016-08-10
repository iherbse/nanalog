import React, {Component, PropTypes} from 'react';
import { Link as LinkComponent } from 'react-router';

const styles = require('./testStyle');

export default class NavBar extends Component {

  render(){

    const logo = (
      <Link to="/" href="#" className="header item">
        <img className="logo" src="../../images/logo.png" style={styles.logoImage}/>
      </Link>
    );

    return (
      <nav className="navbar ui top fixed borderless menu">
        {logo}
      </nav>
    );
  }
}
