# Java9
### Jshell
- shell방식으로 java프로그램 실행 및 작성 가능

### deprecated태그 변경
- forRemoval, since로 변경됨

### Stack Walking
- java8까지는 작업 실행내역을 StackTraceElement를 사용했으나,
java9부터는 StackWalker가 도입됨. java8에 비해 전체 스택 확인이 용이함
```java
StackWalker.getInstance().forEach(System.out::println);

```


### javadoc
- 기존 html4.01로 생성했던 javadoc을 html5로 생성 가능

# Java10
### 로컬변수 타입추론
```java
var str = "string";

```


# Java11

### 단일 컴파일없이 프로그램 시작

```bash
$ java HelloWorld.java

Hello World!
```