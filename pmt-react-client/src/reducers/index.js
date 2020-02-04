import {combineReducers} from 'redux';
import errorReducer from './errorReducer';
import ProjectReducer from './ProjectReducer';
import BacklogReducer from './BacklogReducer';
import securityReducer from './securityReducer';

export default combineReducers ({

    errors:  errorReducer,
    project: ProjectReducer,
    backlog: BacklogReducer,
    security: securityReducer
});