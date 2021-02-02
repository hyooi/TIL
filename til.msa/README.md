# MSA 간단 예제

스프링부트로 개발된 4개의 모듈이 유기적으로 동작하는 멀티 프로젝트

## 빌드

```bash
./gradlew clean build
```

## 실행

```bash
java -jar ./eureka-server/build/libs/eureka-server-0.0.1-SNAPSHOT.jar
java -jar ./product/build/libfis/product-0.0.1-SNAPSHOT.jar
java -jar ./display/build/libs/display-0.0.1-SNAPSHOT.jar
java -jar ./zuul/build/libs/zuul-0.0.1-SNAPSHOT.jar
```

- Eureka server: http://localhost:8761
- Product: http://localhost:8082/products/22222
- Display: http://localhost:8081/displays/11111
- Zuul:
    - http://localhost:8765/product/products/11111
    - http://localhost:8765/display/displays/11111

## 모듈

- display: product의 api를 rest로 get해 사용하는 스프링부트 모듈
- product: rest api를 제공하는 스프링부트 모듈
- eureka-server: eureka server
- zuul: api gateway. display 및 product의 rest api를 프록시하는 역할

## 사용 기술

- hystrix: circuit breaker
- eureka
- zuul: api gateway
- ribbon
- feign
