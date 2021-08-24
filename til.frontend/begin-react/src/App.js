/**
 * useReducer? useState?
 * 관리하는 값이 적다면 useState가 편리
 * 만약 컴포넌트에서 관리하는 값이 많고 상태관리 로직이 복잡해지면 reducer를 활용하는 것을 고민
 */

import './App.css';
import Hello from "./Hello";
import Wrapper from "./Wrapper";
import UserList from "./UserList";
import CreateUser from "./CreateUser";
import {useCallback, useMemo, useReducer, useRef} from "react";
import useInputs from "./hooks/useInputs";

const counterActiveUsers= (users) => {
  return users.filter(user => user.active).length
}

const initialState = {
  users: [
  {
    id: 1,
    username: 'velopert',
    email: 'public.velopert@gmail.com',
    active: false
  },
  {
    id: 2,
    username: 'tester',
    email: 'tester@example.com',
    active: false
  },
  {
    id: 3,
    username: 'liz',
    email: 'liz@example.com',
    active: false
  }
  ]}

const reducer = (state, action) => {
  switch (action.type) {
    case 'CREATE_USER':
    return {
      users: state.users.concat(action.user)
    }

    case 'TOGGLE_USER':
      return {
        users: state.users.map(user => user.id === action.id? {...user, active: !user.active} : user)
      }
    case 'REMOVE_USER':
      return {
        users: state.users.filter(user => user.id !== action.id)
      }
    default:
      return state;
  }
}

function App() {
  const style = {
    backgroundColor: 'black',
    color: 'aqua',
    fontSize: 24,
    padding: '1rem'
  }

  const [{username, email}, onChange, reset] = useInputs({
    username: '',
    email: ''
  })

  const [state, dispatch]= useReducer(reducer, initialState)
  const nextId = useRef(4)

  const {users} = state;

  const onCreate = useCallback(() => {
    dispatch({
      type: 'CREATE_USER',
      user: {
        id: nextId.current,
        username,
        email
      }
    })
    reset() //새로운 항목 추가 시 input초기화
    nextId.current += 1
  }, [username, email])

  const onToggle = useCallback(id => {
    dispatch({
      type: 'TOGGLE_USER',
      id
    })
  }, [])

  const onRemove = useCallback(id => {
    dispatch({
      type: 'REMOVE_USER',
      id
    })
  }, [])

  const count = useMemo(() => counterActiveUsers(users), [users])

  return (
    <div className="App">
      <CreateUser username={username} email={email} onChange={onChange} onCreate={onCreate}/>
      <UserList users={users} onToggle={onToggle} onRemove={onRemove}/>
      <div>활성 사용자 수 : {count}</div>
      <Wrapper>
        {/*주석!*/}
        {/*isSpecial만 쓰면 true로 간주*/}
        <Hello name="react" color="red" isSpecial
          //여기선 이렇게 주석쓰기 가능
        />
        <Hello color="pink"/>
        <div style={style}>name</div>
        <div className="gray-box"/>
      </Wrapper>
    </div>
  );
}

export default App;
