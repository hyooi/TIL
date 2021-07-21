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