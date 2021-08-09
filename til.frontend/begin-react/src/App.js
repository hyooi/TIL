import logo from './logo.svg';
import './App.css';
import Hello from "./Hello";

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
      {/*주석!*/}
      <Hello
        //여기선 이렇게 주석쓰기 가능
      />
      <div style={style}>{name}</div>
      <div className="gray-box"/>
    </div>
  );
}

export default App;
