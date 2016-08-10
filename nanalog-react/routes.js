import React from 'react'
import { Route ,IndexRoute } from 'react-router'
import App from './containers/App'
import WriteDiary from './components/WriteDiary'
import Calender from './components/Calender'


export default (
  <Route path="/" component={App}>
    <IndexRoute component={WriteDiary}/>
    <Route path="/Calender"
        component={Calender}/>
  </Route>
)
