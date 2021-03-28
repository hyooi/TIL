package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 5001번 서버를 열고 기다리는 서버 예제
 */
public class ServerExample {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;

    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost", 5001)); //도메인 사용 시 InetServerAddress이용 필요

      while (true) {
        System.out.println("[연결 기다림]");
        Socket socket = serverSocket.accept();

        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
        System.out.println("[연결 수락됨] " + isa.getHostName());

        byte[] bytes = new byte[100];
        InputStream is = socket.getInputStream();
        int readByteCount = is.read(bytes);
        System.out
            .println("[데이터 받기 성공]:" + new String(bytes, 0, readByteCount, StandardCharsets.UTF_8));

        OutputStream os = socket.getOutputStream();
        bytes = "Hello client".getBytes(StandardCharsets.UTF_8);
        os.write(bytes);
        os.flush();
        System.out.println("[데이터 보내기 성공]");

        is.close();
        os.close();
        socket.close();
      }

    } catch (IOException e) {
      e.printStackTrace();
      
    } finally {
      if (serverSocket != null && !serverSocket.isClosed()) {
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }
}
