import React, {useEffect} from "react";

const User = React.memo(({user, onRemove, onToggle}) => {
  useEffect(() => {
    console.log('user!', user)
  }, [user]) //deps는 의존값. []면 컴포넌트가 처음 렌더링될 때만 호출됨. 비어있으면 리렌더링 시마다 호출

  return (
      <div>
        <b style={{
          cursor: 'pointer',
          color: user.active? 'green' : 'black'
        }} onClick={() => onToggle(user.id)}>{user.username}</b>
        <span>({user.email})</span>
        <button onClick={() => onRemove(user.id)}>삭제</button>
      </div>
  )
})

const UserList = ( {users, onRemove, onToggle} ) => {
  return (
      <div>
        {users.map((user, index) => (
            //배열 렌더링 시 key설정이 없으면 에러발생함. key가 있어야 효율적으로 렌더링하기 때문!
            //예를들어 배열 중간에 데이터 추가 시, key가 없으면 요청 위치부터의 모든 데이터를 변경함
            //그러나 key가 있으면 추가할 데이터만 변경함
            <User user={user} key={index} onRemove={onRemove} onToggle={onToggle}/>
        ))}
      </div>
  )
}

//memo는 잘못 사용 시 버그가 발생할 수 있음
export default React.memo(UserList, (prevProps, nextProps) => prevProps.users === nextProps.users)
