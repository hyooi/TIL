import './App.css';
import Hello from "./Hello";
import Wrapper from "./Wrapper";
import UserList from "./UserList";
import {useRef, useState} from "react";
import CreateUser from "./CreateUser";

function App() {
  const name = 'react';
  const style = {
    backgroundColor: 'black',
    color: 'aqua',
    fontSize: 24,
    padding: '1rem'
  }

//state는 변경한 값으로 랜더링한 후 업데이트된 값을 사용하는 반면, useRef는 설정 후 바로 조회가능
  const nextId = useRef(4);
  const onCreate = () => {
    setUsers([...users, { //스프레드 연산자를 사용하거나, concat으로 복제가능
      id: nextId.current,
      username,
      email
    }])
    setInputs({
      username: '',
      email: ''
    })
    nextId.current += 1;
  }

  const [inputs, setInputs] = useState({
    username: '',
    email: ''
  })
  const {username, email} = inputs;
  const onChange = e => {
    const {name, value} = e.target;
    setInputs({
      ...inputs,
      [name]: value
    })
  }

  const [users, setUsers] = useState([
    {
      id: 1,
      username: 'velopert',
      email: 'public.velopert@gmail.com',
      active: true
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
  ])

  const onToggle = id => {
    setUsers(
        users.map(user => user.id === id? {
          ...user,
          active: !user.active
        } : user)
    )
  }

  const count = (users) => {
    console.log("활성 사용자 수를 세는 중")
    return users.filter(user => user.active).length;
  }

  return (
    <div className="App">
      <CreateUser username={username} email={email} onCreate={onCreate} onChange={onChange}/>
      <UserList users={users} onRemove={id => setUsers(users.filter(user => user.id !== id))}
        onToggle={onToggle}/>
      <div>활성 사용자 수 : {count}</div>
      <Wrapper>
        {/*주석!*/}
        {/*isSpecial만 쓰면 true로 간주*/}
        <Hello name="react" color="red" isSpecial
          //여기선 이렇게 주석쓰기 가능
        />
        <Hello color="pink"/>
        <div style={style}>{name}</div>
        <div className="gray-box"/>
      </Wrapper>
    </div>
  );
}

export default App;
