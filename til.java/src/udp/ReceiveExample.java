package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 수신자 프로그램 DatagramSocket.receive() : 패킷 받을 때까지 블로킹됨
 */
public class ReceiveExample {

  public static void main(String[] args) throws SocketException, InterruptedException {
    DatagramSocket datagramSocket = new DatagramSocket(5001);
    Thread thread = new Thread(() -> {
      System.out.println("수신 시작");
      try {
        while (true) {
          DatagramPacket packet = new DatagramPacket(new byte[100], 100);
          datagramSocket.receive(packet);
          String data = new String(packet.getData(), 0, packet.getLength(),
              StandardCharsets.UTF_8);
          System.out.println("[받은 내용: " + packet.getSocketAddress() + "] " + data);
        }
      } catch (IOException e) {
        System.out.println("[수신 종료]");
      }
    });

    thread.start();
    Thread.sleep(10000);
    datagramSocket.close();
  }
}
