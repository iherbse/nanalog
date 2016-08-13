import React from 'react'
import { Route ,IndexRoute } from 'react-router'
import App from './containers/App'
import DiaryPage from './components/DiaryPage'
import Calender from './components/Calender'


export default (
  <Route path="/" component={App}>
    <IndexRoute component={DiaryPage}/>
    <Route path="/Calender"
        component={Calender}/>
  </Route>
)
