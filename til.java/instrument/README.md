# Java Instrument
이미 컴파일된 java클래스에 바이트코드를 추가하는 기능 제공

## Java agent?
- jvm에 로드된 기존 바이트코드를 변경하기 위해 jvm이 제공하는 instrumentation api 활용함
- 에이전트 정의 방법
    - premain: jvm시작 시 -javaagent 아규먼트를 이용해 에이전트를 정적으로 로드(실행 전에 바이트코드를 수정함)
    - agentmain: java attach api를 사용해 jvm에 에이전트를 동적으로 로드함(이미 실행중인 jvm에 로드)

```bash
./gradlew clean build
java -javaagent:.\agent\build\libs\agent-1.0-SNAPSHOT.jar .\application\build\libs\application-1.0-SNAPSHOT.jar
```
