import React, {useState} from "react";
import {useDispatch} from "react-redux";
import {registerUser} from "../../../_actions/user_action";
import {withRouter} from 'react-router-dom'

function RegisterPage(props) {
  const dispatch = useDispatch()

  const [Email, setEmail] = useState("")
  const [Name, setName] = useState("")
  const [Password, setPassword] = useState("")
  const [ConfirmPassword, setConfirmPassword] = useState("")

  const onEmailHandler = (event) => {
    setEmail(event.currentTarget.value)
  }

  const onNameHandler = (event) => {
    setName(event.currentTarget.value)
  }

  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value)
  }

  const onConfirmPasswordHandler = (event) => {
    setConfirmPassword(event.currentTarget.value)
  }

  const onSubmitHandler = (event) => {
    event.preventDefault(); //화면 리프레시 막아줌

    if (Password !== ConfirmPassword) {
      return alert('비밀번호와 비밀번호 확인이 다릅니다.')
    }

    //redux를 위해 component에서 action함
    dispatch(registerUser({
      email: Email,
      name: Name,
      password: Password
    })).then(response => {
      if(response.payload.success) {
        props.history.push('/login')
      } else {
        alert('Failed to sign up')
      }
    })
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

          <label>Name</label>
          <input type="text" value={Name} onChange={onNameHandler} />

          <label>Password</label>
          <input type="password" value={Password} onChange={onPasswordHandler} />

          <label>Confirm password</label>
          <input type="password" value={ConfirmPassword} onChange={onConfirmPasswordHandler} />

          <br/>
          <button type="submit">Register</button>
        </form>
      </div>
  )
}

export default withRouter(RegisterPage)