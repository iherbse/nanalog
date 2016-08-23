import React from 'react'
import { Route ,IndexRoute } from 'react-router'
import App from './containers/App'
import WeeklyPage from './containers/WeeklyPage'
import MonthlyPage from './containers/MonthlyPage'
import WeeklyWritePage from './containers/WeeklyWritePage'

export default (
  <Route path="/" component={App}>
    <IndexRoute component={MonthlyPage}/>
    <Route path="/MonthlyPage"
        component={MonthlyPage}/>
    <Route path="/WeeklyPage/:day"
        component={WeeklyPage}/>
        <Route path="/WeeklyPage/:day/:pageId"
            component={WeeklyPage}/>
    <Route path="/WeeklyPage"
        component={WeeklyPage}/>
  </Route>
)
