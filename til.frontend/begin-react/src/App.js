import './App.css';
import Hello from "./Hello";
import Wrapper from "./Wrapper";
import UserList from "./UserList";
import {useCallback, useMemo, useRef, useState} from "react";
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
  const [inputs, setInputs] = useState({
    username: '',
    email: ''
  })
  const {username, email} = inputs;
  const onChange = useCallback(e => {
    const {name, value} = e.target;
    setInputs({
      ...inputs,
      [name]: value
    })
  }, []);

  const [users, setUsers] = useState([
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
  ])

  //컴포넌트 리렌더링 시마다 함수가 새로 만들어짐
  const onCreate = useCallback(() => {
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
  }, [username, email])

  const onToggle = useCallback(id => {
    setUsers(
        users.map(user => user.id === id? {
          ...user,
          active: !user.active
        } : user)
    )

    const user = users.filter(user => user.id === id)[0]
    let username = ''
    let email = ''

    if(!user.active) {
      username = user.username;
      email = user.email;
    }

    setInputs({username, email})
  }, []) //deps에 사용하는 props, 상태를 포함해야 가장 최신 값을 참조함함
  //deps의 내용이 바뀌면 함수를 호출하고, 그렇지 않으면 이전 값 재사용
  const count = useMemo(() => {
    return users.filter(user => user.active).length;
  }, [users])

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
