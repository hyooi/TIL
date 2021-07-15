# 프론트엔드 개발 환경의 이해

[프론트엔드 개발 환경의 이해](http://jeonghwan-kim.github.io/series/2019/12/09/frontend-dev-env-npm.html)

## Node

- init: package.json에 프로젝트 정보를 기록한다.

``` bash
npm init
```

- 테스트 스크립트 실행

```bash
npm test
```

- 커스텀 명령어 실행

```bash
npm run build
```

- npm레파지토리에서 외부 패키지 다운로드

```bash
npm install axios
```

- 버전?

1. 특정 버전 : ex) 1.2.3
2. 특정 버전보다 높거나 낮은 경우 ex) >1.2.3, >=1.2.3, <1.2.3, <=1.2.3

3. 틸트: 마이너버전이 명시된 경우엔 패치버전만 변경, 마이너버전이 없는 경우엔 마이너버전까지 갱신. ex. ~1.2.3(1.2.3~1.3.0미만 버전 포함)

4. 캐럿: 마이너와 패치 버전 변경 ex. ^1.2.3(1.2.3~2.0.0미만 버전 포함)

## 웹팩

- webpack dev dependency로 추가

```bash
npm install -D webpack webpack-cli
```

- 하나의 js로 번들링

``` bash
node_modules/.bin/webpack --mode development --entry ./src/app.js -o ./dist
```

- webpack.config.js사용

1. webpack.config.js를 정의하고,
2. package.json에 custom script를 설정한다. build명령어 실행 시 webpack을 실행하도록 하면, 먼저 node_modules의 webpack을 찾고,
   없으면 전역 webpack을 찾아 webpack을 실행한다.

```bash
npm run build
```

### 로더

- 웹팩은 자바스크립트 모듈뿐만이 아니라 CSS,이미지, 폰트까지도 모듈로 본다. 따라서 import를 통해 자바스크립트 코드로 해당 모듈들을 가져올 수 있다.

- css적용법

1. css loader 및 style loader를 추가한다.
2. css loader는 css를 모듈로 변환해주며, style loader는 자바스크립트로 변경된 css를 동적으로 돔에 추가해준다.

```bash
npm install -D css-loader
npm install -D style-loader
```

- 이미지 로드

1. file loader를 통해 이미지를 로딩할 수 있는데, 작은 이미지를 여러개 사용하는 경우 base64로 인코딩해 문자열 형태로 이미지를 사용하는 data uri
   scheme를 사용할 수 있다.
2. 이 때 사용하는 것이 url loader!

### 플러그인

로더와 달리 번들링된 최종 결과물을 처리한다.

- Banner plugin: 번들된 최종결과물 상단에 배너를 추가한다.
- Define plugin: 개발/운영 환경 분리 시 환경 정보를 플러그인으로 주입 가능
    - console.log(process.env.NODE_ENV)를 기본으로 제공
- Html Webpack plugin: html도 동적으로 생성함.

```bash
NODE_ENV=development npm run build
```

- Clean webpack plugin: 빌드 전에 이전 결과물을 삭제함
- MiniCssExtract plugin: 속도 개선을 위해 css를 별도의 파일로 분리

## 바벨

ECMAScript2015 이상의 코드를 하위 버전으로 트랜스파일한다. 인터넷 익스플로러나 구버전 브라우저와 같이 최신 JS를 읽지 못하는 환경에서 동작시키기 위해 사용한다.

- 바벨 실행: node_modules에 babel command가 있으면 쓰고, 아니면 global babel사용 babel core는 파싱, 출력만 진행. 변환을 하기 위해서는
  플러그인 사용이 필요

```bash
npx babel app.js
npx babel --plugins my-babel-plugin.js app.js
npx babel --plugins @babel/plugin-transform-block-scoping app.js //위의 custom plugin과 동일한 역할 수행
```

### 프리셋

- 바벨 실행 시 상위처럼 일일이 플러그인을 지정하지는 않고, 보통 프리셋을 지정해 사용한다. 목적에 맞게 하나 이상의 플러그인을 모아놓은 것을 프리셋이라 한다.

```bash
npx babel app.js //프리셋 지정 후 실행해야 변환됨
```

- 프리셋 예시

1. preset-env: ECMAScript2015+ 변환 시 사용. 가장 많이 사용함
2. preset-flow: flow변환 시 사용
3. preset-react: react변환 시 사용
4. preset-typescript: typescript변환 시 사용

### 폴리필

- 변환 시 ECMAScript5로 변환하지 못하는 문법이 있을 수 있음(ex. Promise)
  이 때 폴리필을 통해 코드조각을 추가해 해결 가능

## ESLint

- ECMAScript코드에서 문제점을 검사하고, 더 나은 코드로 정정하는 도구
- 코드의 가독성을 높이고 잠재적인 오류와 버그를 제거

```bash
npx eslint ./src/app.js //lint실행
npx eslint ./src/app.js --fix //lint실행 및 자동 수정
```

### Extensible Config

- recommand된 eslint 룰을 설정할 수 있음

1. recommended: 자주 사용하는 rule 사용
2. airbnb: airbnb 스타일 가이드를 따름
3. standard: 자바스크립트 스탠다드 스타일

### 초기화

init옵션을 통해 쉽게 eslint설정 가능

```bash
npx eslint --init
```

## Prettier

- 코드를 예쁘게 만들어줌 EX. 긴 문장, 파라미터가 많은 메소드 등

```bash
npx prettier app.js --write //파일 재작성
npx prettier app.js //결과를 터미널에 출력
```

### ESlint와 통합하기

- eslint-config-prettier 패키지를 통해 프리티어와 충돌하는 ESLint 규칙을 끌 수 있음
- eslint-config-prettier 플러그인을 사용하면, 프리티어의 모든 rule이 eslint로 들어오므로 eslint만 실행하면 됨

```bash
npx src/eslint app.js --fix
```

## 자동화

### husky

- git hook을 쉽게 사용 가능
- 커밋 시마다 린트 수행이 가능함

### lint-staged

- 변경된 파일만 린트 수행

## webpack dev server

- 수정 시마다 리프레시되는 개발서버
- 목업api 사용 가능

```bash
$ curl localhost:8081/api/keywords
[{"keyword":"이탈리아"},{"keyword":"세프의요리"},{"keyword":"제철"},{"keyword":"홈파티"}]
```

### connect-api-mocker

목업 api가 많은 경우 사용하기 편리함

```bash
$ curl localhost:8081/api/keywords
[{"keyword":"이탈리아"},{"keyword":"세프의요리"},{"keyword":"제철"},{"keyword":"홈파티"}]
```

### hot module replacement

- 웹팩 데브서버는 기본적으로 전체화면을 갱신하는데, 변경한 모듈만 변경하고 싶을 때 사용함
- * TODO) webpack5에서 dev server reloading이 제대로 안되는듯. 재확인할 것


## 최적화
### production모드
- 웹팩은 자동으로 플러그인을 적용하는데,
development모드에서는 NamedChunksPlugin, NamedModulesPlugin을 적용하고, 
  자바스크립트 결과물을 최소화하는 7개 플러그인을 적용한다.
  따라서 빌드 시엔 반드시 production모드로 빌드해야 한다.


### optimization
- optimize-css-assets-webpack-plugin: css의 빈칸을 삭제
- TerserWebpackPlugin: 자바스크립트 코드 난독화, debug구문 제거. console로그 제거 가능
- SplitChunksPlugin: js다운로드 속도 개선을 위해 엔트리를 분리하는 경우, 발생할 수 있는 중복코드를 제거함
- externals: 이미 빌드된 js는 다시 빌드하지 않도록 제외. 단 copyWebpackPlugin으로 js를 카피해야 함. 또한 index.html에도 추가필요

