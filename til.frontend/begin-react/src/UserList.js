const User = ({user}) => {
  return (
      <div>
        <b>{user.username}</b> <span>({user.email})</span>
      </div>
  )
}

const UserList = () => {
  const users = [
    {
      id: 1,
      username: 'velopert',
      email: 'public.velopert@gmail.com'
    },
    {
      id: 2,
      username: 'tester',
      email: 'tester@example.com'
    },
    {
      id: 3,
      username: 'liz',
      email: 'liz@example.com'
    }
  ];

  return (
      <div>
        {users.map((user, index) => (
            //배열 렌더링 시 key설정이 없으면 에러발생함. key가 있어야 효율적으로 렌더링하기 때문!
            //예를들어 배열 중간에 데이터 추가 시, key가 없으면 요청 위치부터의 모든 데이터를 변경함
            //그러나 key가 있으면 추가할 데이터만 변경함
            <User user={user} key={index}/>
        ))}
      </div>
  )
}

export default UserList
