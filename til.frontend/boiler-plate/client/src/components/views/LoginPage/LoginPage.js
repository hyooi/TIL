import React, {useState} from "react";
import {useDispatch} from "react-redux";
import {loginUser} from "../../../_actions/user_action";

function LoginPage() {
  const dispatch = useDispatch()
  const [Email, setEmail] = useState("")
  const [Password, setPassword] = useState("")

  const onEmailHandler = (event) => {
    setEmail(event.currentTarget.value)
  }

  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value)
  }

  const onSubmitHandler = (event) => {
    event.preventDefault(); //화면 리프레시 막아줌
    dispatch(loginUser({
      email: Email,
      password: Password
    })) //redux를 위해 component에서 action함
  }

  return (
    <div style={{
      display: 'flex', justifyContent: 'center', alignItems: 'center',
      width: '100%', height: '100vh'
    }}>
      <form style={{ display: 'flex', flexDirection: 'column'}}
        onSubmit={onSubmitHandler}>
        <label>Email</label>
        <input type="email" value={Email} onChange={onEmailHandler} />
        <label>Password</label>
        <input type="password" value={Password} onChange={onPasswordHandler} />
        <br/>
        <button type="submit">Login</button>
      </form>
    </div>
  )
}

export default LoginPage