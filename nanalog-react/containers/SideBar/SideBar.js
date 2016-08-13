import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';

class SideBar extends Component {

    render() {
        return (
            <div className="side-content">
                <ul className="itemlist">
                    <li>
                        <Link to="/" href="#" className="item">
                            <img className="logo" src={require('../../images/nav-item.png')}/>
                        </Link>
                    </li>
                    <li>
                        <Link to="/" href="#" className="item">
                            <img className="logo" src={require('../../images/nav-item.png')}/>
                        </Link>
                    </li>
                    <li>
                        <Link to="/" href="#" className="item">
                            <img className="logo" src={require('../../images/nav-item.png')}/>
                        </Link>
                    </li>
                </ul>
            </div>
        )
    }
}

export default SideBar;
