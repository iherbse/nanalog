import React, {Component, PropTypes} from 'react';
import {Link} from 'react-router';
import SkyLight from 'react-skylight'

class NavBar extends Component {

    constructor(props) {
        super(props)
        this.handleLoginClick = this.handleLoginClick.bind(this)
    }
    handleLoginClick() {
        this.refs.loginDialog.show();
    }
    render() {
        return (
            <div className="nav">
                <Link to="/" href="#">
                    <img src={require('../../images/logo.svg')} className="logo"/>
                </Link>
                <Link to="/" href="#">
                    <img src={require('../../images/btn_mypage.svg')} className="mypage" onClick={this.handleLoginClick}/>
                </Link>
                <SkyLight dialogStyles={styles.loginDialog} hideOnOverlayClicked ref="loginDialog" overlayStyles={styles.myoverlayStyles}>
                    <ul style={styles.ul}>
                        <li>
                            <h3 style={styles.title}>SIGN IN</h3>
                        </li>
                        <li><input style={styles.input} type="text" ref="input"/></li>
                        <li><input style={styles.input} type="text" ref="input"/></li>
                        <li>
                            <button style={styles.button}>Sign in</button>
                        </li>
                    </ul>

                    <ul style={styles.ul_login}>
                        <h5 style={styles.li_login}>
                            Facebook
                        </h5>
                        <h5 style={styles.li_login}>
                            Google
                        </h5>
                        <h5 style={styles.li_login}>
                            Wechat
                        </h5>
                    </ul>
                </SkyLight>
            </div>
        )
    };

}
var styles = {
    title: {
        textAlign: 'right',
        marginTop: '50px',
        marginRight: '164px',
        size: '30pt'
    },
    ul: {
        listStyleType: 'none'
    },
    ul_login: {
        listStyleType: 'none',
        marginTop: 110,
        marginLeft: 10

    },
    input: {

        marginLeft: -10,
        marginTop: 10,
        width: '90%',
        height: 20,
        backgroundColor: '#A4A4A4 '
    },
    button: {
        marginLeft: -10,
        marginTop: 20,
        width: '90%'
    },
    li_login: {
        float: 'left',
        marginLeft: 10
    },
    loginDialog: {
        color: '#000000 ',
        width: '20%',
        height: '400px',
        right:'-20%',
        marginTop: '78px',
    marginLeft: '25%'
    },
    myoverlayStyles: {
        zIndex: 99
    }
}

export default NavBar;
