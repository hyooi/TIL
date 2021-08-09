# React JS
- 브라우저에 실제로 보여지는 dom이 아니라, 메모리에 가상으로 존재하는 virtual dom을 활용
- 따라서 virtual dom을 사용하면 실제로 브라우저에서 dom을 사용하는 것보다 훨씬 빠름
- react는 virtual dom이 변경되면, 실제 브라우저의 dom과 비교해 변경된 부분을 실제 dom에 패치함


## JSX
- 리액트 컴포넌트에서 xml 형식의 값을 반환

### 스타일 지정
- 인라인으로 지정 시: 객체 형태로 작성해야 하며, 카멜케이스를 사용해야 함
```html
  <div style={style}>{name}</div>
```
- css사용 시: class가 아닌 className으로 지정
```html
  <div className="gray-box"></div>
```
