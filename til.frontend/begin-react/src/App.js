import './App.css';
import Hello from "./Hello";
import Wrapper from "./Wrapper";
import UserList from "./UserList";

function App() {
  const name = 'react';
  const style = {
    backgroundColor: 'black',
    color: 'aqua',
    fontSize: 24,
    padding: '1rem'
  }
  return (
    <div className="App">
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
