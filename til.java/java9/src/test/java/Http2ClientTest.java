import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Http2ClientTest {

  @Test @SneakyThrows
  @DisplayName("HTTP2 클라이언트 테스트")
  void http2_client_test() {
    var httpClient = HttpClient.newHttpClient();
    var httpRequest = HttpRequest.newBuilder()
        .uri(new URI("https://hyooi.github.io/"))
        .GET()
        .build();

    var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    System.out.println(httpResponse.body());
  }

  @Test @SneakyThrows
  @DisplayName("HTTP2 비동기 클라이언트 테스트")
  void http2__async_client_test() {
    var httpClient = HttpClient.newHttpClient();
    var httpRequest = HttpRequest.newBuilder()
        .uri(new URI("https://hyooi.github.io/"))
        .GET()
        .build();

    var httpResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    if(httpResponse.isDone()) {
      System.out.println(httpResponse.get().statusCode());
      System.out.println(httpResponse.get().body());
    } else {
      httpResponse.cancel(true);
    }
  }
}
