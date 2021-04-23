# Java9
### 1. 인터페이스에서 private method사용 가능

### 2. HTTP2 Client

### 3. Jshell
- shell방식으로 java프로그램 실행 및 작성 가능

### 4. deprecated태그 변경
- forRemoval, since로 변경됨

### 5. Stack Walking
- java8까지는 작업 실행내역을 StackTraceElement를 사용했으나,
java9부터는 StackWalker가 도입됨. java8에 비해 전체 스택 확인이 용이함
```java
StackWalker.getInstance().forEach(System.out::println);
```

### 6. javadoc
- 기존 html4.01로 생성했던 javadoc을 html5로 생성 가능

### 7. String compression
- char[]였던 String클래스가 byte[]로 변경됨. 그러면서 메모리 사용량이 50%로 줄어듦.
- 힙메모리 사용량 줄임

### 8. 불변list, set, map 생성 가능
```java
List<String> namesList = List.of("Lokesh", "Amit", "John");
 
Set<String> namesSet = Set.of("Lokesh", "Amit", "John");

Map<String, String> namesMap = Map.ofEntries(
                            Map.entry("1", "Lokesh"),
                            Map.entry("2", "Amit"),
                            Map.entry("3", "Brian"));
```


# Java10
### 로컬변수 타입추론
```java
var str = "string";
```


# Java11

### 1. 단일파일은 컴파일없이 프로그램 시작 가능
```bash
$ java HelloWorld.java

Hello World!
```

### 2. builder패턴의 HttpClient



# Java12

### 1. 유니코드11 지원

### 2. 화살표 구문 switch

# Java13


# Java14


# Java15

