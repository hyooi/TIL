import React, {useEffect} from "react";
import {useDispatch} from "react-redux";
import {auth} from "../_actions/user_action"

/*
option:
- null: 아무나 접근가능
- true: 로그인한 유저만 접근 가능
- false: 로그아웃한 유저만 접근 가능

adminRoute:
- true면 어드민 유저만 접근 가능
 */
export default function (SpecificComponent, option, adminRoute = null) {
  function AuthenticationCheck(props) {
    const dispatch = useDispatch()
    useEffect(() => {
      dispatch(auth()).then(response => {
        console.log(response)

        if(!response.payload.isAuth) {
          if(option) {
            props.history.push('/login')
          }
        } else {
          if(adminRoute && !response.payload.isAdmin) {
            props.history.push('/')
          } else {
            if(!option) {
              props.history.push('/')
            }
          }
        }
      })
    }, [])

    return (<SpecificComponent/>)
  }

  return AuthenticationCheck
}