package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * 발신자 프로그램
 * - 수신자를 먼저 실행하고 실행해야 함
 * - 발신자를 먼저 실행하는 경우, 수신자가 기동되기 전에 요청된 데이터는 유실됨
 */
public class SendExample {

  public static void main(String[] args) throws IOException {
    DatagramSocket datagramSocket = new DatagramSocket();
    System.out.println("[발신 시작]");

    for (int i=1; i<3; i++) {
      String data = "메시지"+i;
      byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

      DatagramPacket packet = new DatagramPacket(bytes, bytes.length
          , new InetSocketAddress("localhost", 5001));
      datagramSocket.send(packet);
      System.out.println("[보낸 바이트 수]: " + bytes.length + "bytes");
    }

    System.out.println("[발신 종료]");
    datagramSocket.close();
  }
}
