import React from "react";

const CreateUser = ({ username, email, onChange, onCreate }) => {
  return (
      <div>
        <input name="username" placeholder="계정명" onChange={onChange} value={username}/>
        <input name="email" placeholder="이메일" onChange={onChange} value={email}/>
        <button onClick={onCreate}>등록</button>
      </div>
  )
}

export default React.memo(CreateUser) //memo 시 리렌더링이 필요할 때만 렌더링하도록 설정 가능
