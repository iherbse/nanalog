import React, {Component, PropTypes} from 'react';
import {render} from 'react-dom';
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import NavBar from './NavBar/NavBar';
<<<<<<< HEAD
import SideBar from './SideBar/SideBar';
=======
import NavUser from './NavBar/NavUser';
import {fetchPageList} from '../actions/diary'
>>>>>>> 79dfe9d188abf3eeb024657d837d2f6dbec494fc

function signupTest(props,uid,name,password){
  props.fetchPageList('url')
  console.log("click!!");
}
class App extends Component {
    constructor(props) {
        super(props)
        this.signuptest2=this.signuptest2.bind(this);
    }
    signuptest2(uid,name,password){
      signupTest(this.props,"uid","name","password123")
    }

    render() {
        const {children} = this.props

        return (

            <div id="wrap-content">
<<<<<<< HEAD

=======
                <button onClick = {this.signuptest2}>click</button>
>>>>>>> 79dfe9d188abf3eeb024657d837d2f6dbec494fc
                <NavBar/>
                <SideBar/>
                <main id="main-content">
                    {children}
                </main>
                <div id="side-content-right">
                  <NavUser/>
                </div>

            </div>

        )
    }
}
function mapStateToProps(state, ownProps) {
  return {}
}
export default connect(mapStateToProps, {
  fetchPageList
})(App)

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node,
    fetchPageList:PropTypes.func.isRequired
}
