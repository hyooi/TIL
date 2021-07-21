import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Auth from '../hoc/auth'
import LandingPage from "./views/LandingPage/LandingPage";
import LoginPage from "./views/LoginPage/LoginPage";
import RegisterPage from "./views/RegisterPage/RegisterPage";

export default function App() {
  return (
      <Router>
        <div>
          <nav>
          </nav>

          {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
          <Switch>
            <Route exact path="/" component={Auth(LandingPage, null)}/>
            <Route exact path="/login" component={Auth(LoginPage, false)}/>
            <Route exact path="/register" component={Auth(RegisterPage, false)}/>
          </Switch>
        </div>
      </Router>
  )
}
