# Oracle Java SE Support Roadmap
![picture](oracle-java-roadmap.PNG)

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



# Java14

### 1. 패턴 매칭 instanceof(preview)
obj가 String타입인지 확인하고 s에 바인딩함
```java
if (obj instanceof String s) {
    // can use s here
} else {
    // can't use s here
}
```

### 2. 텍스트 블록(preview)
```java
String textBlock = """
                    World""";
```

### 3. switch case
```java
public static Boolean isWeekDay (Day day) 
{
    Boolean result = switch(day) {
        case MON, TUE, WED, THUR, FRI ->
        { 
            System.out.println("It is WeekDay");
            yield true; 
        }
        case SAT, SUN ->
        { 
            System.out.println("It is Weekend");
            yield false; 
        }
    };
    return result;
}
```

# Java15
### 1. sealed class, sealed interface(preview)
```
sealed class Account
    permits CurrentAccount, SavingAccount, LoanAccount {
}
  
final class CurrentAccount extends Account {}
non-sealed class SavingAccount extends Account {}
sealed class LoanAccount extends Account permits HomeloanAccount, AutoloanAccount {}
  
final class HomeloanAccount extends LoanAccount{}
final class AutoloanAccount extends LoanAccount{}
```

### 2. text block


# Java16
### 1. instanceof 패턴매칭 
### 2. records
데이터 설정 및 가져올 때 필요한 상용구 코드를 제거함. immutable이며 final임 <br/>
ex. 생성자, 게터, hashcode, equals

### 3. 패키징 툴
자체 포함된 Java 응용 프로그램을 패키징 하기 위한 jpackage 도구를 제공함.<br/>
msi, exe (Windows), pkg, dms (macOS), deb, rpm (Linux) 형식을 지원