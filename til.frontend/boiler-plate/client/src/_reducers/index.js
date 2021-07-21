import { combineReducers } from 'redux'; //reducer가 여러개인 경우 combineReducer로 합쳐줌
import user from './user_reducer';

const rootReducer = combineReducers({
  user
})

export default rootReducer