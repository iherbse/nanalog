import { createStore, applyMiddleware, compose } from 'redux'
import createLogger from 'redux-logger'
import rootReducer from '../reducer'


export default function configureStore(initialState) {
  const store = createStore(
    rootReducer,
    initialState
  )

  if (module.hot) {
    // Enable Webpack hot module replacement for reducers
    module.hot.accept('../reducer', () => {
      const nextRootReducer = require('../reducer').default
      store.replaceReducer(nextRootReducer)
    })
  }

  return store
}
