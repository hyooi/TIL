# til.java
자바 예제

## 네트워크IO 예제
- tcp
- udp

### TCP
연결 지향적 프로토콜

- 스레드가 블로킹되는 경우:
1. ServerSocket.accept():해당 작업이 종료될때까지 블로킹
2. Socket.connect(): 해당 작업이 종료될때까지 블로킹
3. InputStream.read(): 상대방이 데이터를 보내기 전까지 블로킹
4. OutputStream.write(): 데이터를 완전하게 보내기 전까지 블로킹<br/>
*상대방이 데이터를 보내거나, 상대방이 정상종료했거나, 상대방이 비정상 종료했을때만 블로킹 해제됨

- 스레드 병렬 처리
1. 클라이언트가 연결 요청을 하면 서버는 해당 작업을 작업 큐에 넣는다.
2. 서버의 스레드풀1에서 작업큐에서 작업을 가져와 연결 수락을 하고 socket을 생성한다.
3. 클라이언트가 작업 요청을 하면 서버는 해당 작업을 작업 큐에 넣는다.
4. 서버의 스레드풀2에서는 작업큐에서 작업을 가져와 요청을 처리한다.
5. 요청을 처리한 후에는 응답을 클라이언트로 보낸다.

### UDP
비연결 지향적 프로토콜