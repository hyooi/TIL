import {useReducer, useState} from "react";

//reducer-> useState 외의 상태관리하는 방법. 컴포넌트의 상태 업데이트 로직을 컴포넌트에서 분리시킬 수 있음
//state: 컴포넌트의 상태
//dispatch: 액션을 발생시키는 함수
const reducer = (state, action) => {
  switch (action.type) {
    case 'INCREMENT':
      return state + 1;
    case 'DECREMENT':
      return state - 1;
    default:
      return state;
  }
}
const Counter = () => {
  const [number, dispatch] = useReducer(reducer, 0)

  const onIncrease = () => {
    dispatch({type: 'INCREMENT'})
    // setNumber(number+1)
  }

  const onDecrease = () => {
    dispatch({type: 'DECREMENT'})
    // setNumber(number-1)
  }

  return (
      <div>
        <h1>{number}</h1>
        <button onClick={onIncrease}>+1</button>
        <button onClick={onDecrease}>-1</button>
      </div>
  )
}

export default Counter
