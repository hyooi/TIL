import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 내PC의 IP와 특정 도메인의 IP 출력
 */
public class InetAddressExample {

  public static void main(String[] args) {
    try {
      InetAddress local = InetAddress.getLocalHost();
      System.out.println("내컴퓨터 ip주소: " + local.getHostAddress());

      InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
      for (InetAddress remote : iaArr) {
        System.out.println("www.naver.com ip주소: " + remote.getHostAddress());
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
