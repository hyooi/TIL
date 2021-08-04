# 타입스크립트

- **javascript의 런타임 특성**을 가진 프로그래밍 언어
- 단, javascript와는 달리 컴파일타임 타입 검사자가 있음
- javascript와 같은 라이브러리를 사용하므로, typescript관련 프레임워크를 별도로 공부할 필요가 없다. ex. typescript의 리스트 사용법 =
  javascript의 리스트 사용법
- 타입스크립트의 목표: javascript프로그램의 정적 타입 검사자

## 타입스크립트 > 자바스크립트 컴파일

- 컴파일 시 오류가 발생하더라도 typescript사용이 가능함.
- 그러나 코드가 예상대로 작동하지 않을 것이란 경고를 해줌

```
tsc greeter.ts
```

# Contents

1. 기본 타입
  - boolean
  - number
  - string
  - array
  - tuple
  - enum
  - any
  - void
  - null and undefiend
  - never
  - object
  - type assertions

2. 인터페이스
  - interface
  - optional property
  - readonly
  - excess property checks
  - function type
  - indexable type
  - implement an interface
  - static and instance of classes
  - extending interface

3. 함수
4. 리터럴 타입
5. 유니언과 교차타입
6. 클래스
7. 열거형
8. 제네릭
