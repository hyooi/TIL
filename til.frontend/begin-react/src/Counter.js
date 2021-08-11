import {useState} from "react";

const Counter = () => {
  const [number, setNumber] = useState(0)

  const onIncrease = () => {
    // setNumber(number+1)
    setNumber(prevState => prevState + 1);
  }

  const onDecrease = () => {
    // setNumber(number-1)
    setNumber(prevState => prevState -1); //기존값을 변경하는 식으로도 업데이트 가능
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
