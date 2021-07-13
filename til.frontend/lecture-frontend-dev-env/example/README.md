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
2. 특정 버전보다 높거나 낮은 경우
ex) >1.2.3, >=1.2.3, <1.2.3, <=1.2.3

3. 틸트: 마이너버전이 명시된 경우엔 패치버전만 변경,
마이너버전이 없는 경우엔 마이너버전까지 갱신.
ex. ~1.2.3(1.2.3~1.3.0미만 버전 포함)

4. 캐럿: 마이너와 패치 버전 변경
ex. ^1.2.3(1.2.3~2.0.0미만 버전 포함)


# 웹팩으로 번들링하기
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
2. package.json에 custom script를 설정한다.
build명령어 실행 시 webpack을 실행하도록 하면, 먼저 node_modules의 webpack을 찾고,
   없으면 전역 webpack을 찾아 webpack을 실행한다.
```bash
npm run build
```
