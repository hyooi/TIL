# Node js
- 기존에는 js를 항상 브라우저를 통해서만 사용 가능했음.
- js를 브라우저가 아닌 서버 사이드에서 사용가능하도록 한 언어

# Express js
- node js를 이용해 쉽게 개발할 수 있게 해주는 프레임워크

# Mongoose
- mongo db사용을 위한 라이브러리

# Nodemon
- 노드 서버에 변경된 소스를 적용하려면 서버를 재기동해야하는데,
nodemon은 변경된 내용을 자동으로 감지하여 변경해줌
  
# React js
- 페이스북에서 2013년에 발표한 프론트엔드 라이브러리
- 모듈과 비슷하게 컴포넌트로 이뤄져 재사용성이 뛰어남
- virtual dom
  - 화면 전체를 리프레쉬하지 않고, 수정한 부분만 업데이트할 수 있음
  - virtual dom은 리스트가 10개가 있다고 할 때, 수정 전을 snapshot을 찍어놓고,
    수정 후와 비교하여 변경된 부분만 업데이트하는 방식
```
npx create-react-app .
npm run start
```

## React router dom
- 화면별 라우팅 기능

# npm와 npx
## npm
- 레지스트리 역할 및 빌드 등의 명령어 실행 역할

## npx
- 노드 레지스트리에 있는 것을 로컬에 다운로드받지 않고 실행 가능(ex. create-react-app)

# CORS(=Cross Origin Resource Sharing)
- origin 사이의 리소스 쉐어링 정책
- 도메인이 같고 포트가 같으면 무관하나, 서로 다른 도메인이거나, 
  서로 다른 포트인 경우엔 CORS정책에 의해 리소스 공유가 제한받는다.
  
# Redux
- 상태 관리 라이브러리
- 별도의 redux store를 두고 상태를 관리해 부모 자식node간 상태를 공유할 수 있게 해줌

## Props(=Property)
- 부모, 자식간 컴포넌트의 상태를 공유하고 싶을 경우 사용
- 부모에서 자식으로만 보낼 수 있음
- 상태가 변화하려면 부모에서 내려주어야 함(immutable)
EX)
```javascript
<ChatMessages
  messages={messages}
  currentMember={member}
/>
```
## State
- 상태 공유!
- 컴포넌트에서 직접 값 변환 가능(mutable)
- state가 변하면 다시 랜더링됨
EX)
```javascript
status = {
  message: '',
  attachFile: undefined,
  openMenu: false
}
```

## 리덕스 라이브러리
- 리덕스 스토어는 반드시 plain object로 된 action만 받을 수 있음.
- 그러나 때때로 promise나 function형태의 object를 받아야할 때가 있는데,
그 때 redux thunk나 redux promise를 사용하게됨
### redux thunk
- plain object대신 function형태의 object를 받게해줌

### redux promise
- plain object대신 promise형태의 object를 받게해줌

### redux extension
- redux dev tools사용 시 설정 필요

# React hooks

## React component
### class component
- 많은 기능을 사용할 수 있으나 코드가 길어지고 성능이 상대적으로 느려짐
- component의 라이프사이클인 mounting/unmounting될때의 메소드 등을 사용 가능
```javascript
//constructor > render -> componentDidmount순으로 진행됨
export default class Hello extends Component {
  constructor(props) {
    super(props);
    this.state = { name: "" };
  }

  function

  componentDidMount() {
    Axios.get('/api/user/name')
      .then(response => {
        this.setState({ name: response.data.name })
      })
  }

  render() {
    return (
        <div>
          hello {this.state.name}
        </div>
    )
  }
}
```

### functional component
- 코드가 간단해지고, 성능이 좀 더 빠르나 기능이 더 적음
- 리액트 16.8부터는 react hook으로 class component와 동일하게 구현 가능해짐
```javascript
export default function Hello() {
  donst [Name, setName] = useState("")
  
  useEffect(() => {
    Axios.get('/api/user/name')
    .then(response => {
      setName(response.data.name)
    })
  }, [])
  
  return (
      <div>
        hello {Name}
      </div>
  )
}
```