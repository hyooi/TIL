package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 5001번 포트로 연결하는 클라이언트 예제(ServerExample에 요청)
 */
public class ClientExample {

  public static void main(String[] args) {
    Socket socket = null;

    try {
      socket = new Socket();
      System.out.println("[연결 요청]");
      socket.connect(new InetSocketAddress("localhost", 5001));
      System.out.println("[연결 성공]");

      // 서버 연결 후 클라이언트는 Hello server를 서버에 보냄
      OutputStream os = socket.getOutputStream();
      os.write("Hello server".getBytes(StandardCharsets.UTF_8));
      os.flush();
      System.out.println("[데이터 보내기 성공]");

      // 서버는 Hello Client를 클라이언트로 보냄
      InputStream is = socket.getInputStream();
      byte[] bytes = new byte[100];
      int readByteCount = is.read(bytes);
      String message = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
      System.out.println("[데이터 받기 성공]: " + message);

      os.close();
      is.close();

    } catch (IOException e) {
      e.printStackTrace();

    } finally {
      if (socket != null && !socket.isClosed()) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }
}
