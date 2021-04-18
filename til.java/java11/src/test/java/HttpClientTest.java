import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HttpClientTest {

  @Test
  @SneakyThrows
  @DisplayName("HttpClient 동기 요청")
  void sync_httpClient() {
    var httpclient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build();

    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://hyooi.github.io/"))
        .build();

    var response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());
    System.out.println(response.headers().allValues("content-type"));
    System.out.println(response.body());
  }

  @Test
  @SneakyThrows
  @DisplayName("HttpClient 비동기 요청")
  void async_httpClient() {
    var uris = Stream.of("https://www.google.com",
        "https://www.github.com",
        "https://www.yahoo.com")
        .map(URI::create)
        .collect(Collectors.toList());

    var httpClient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .followRedirects(Redirect.ALWAYS)
        .build();

    var futures = uris.stream()
        .map(uri -> verifyUri(httpClient, uri))
        .toArray(CompletableFuture[]::new);

    CompletableFuture.allOf(futures)
        .join();
  }

  private CompletableFuture<Void> verifyUri(HttpClient httpClient, URI uri) {
    var request = HttpRequest.newBuilder()
        .timeout(Duration.ofSeconds(5))
        .uri(uri)
        .build();

    return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::statusCode)
        .thenApply(statusCode -> statusCode == 200)
        .exceptionally(ex -> false)
        .thenAccept(valid -> {
          if (valid) {
            System.out.println("[success verified]" + uri);
          } else {
            System.out.println("[failure] colud not verified" + uri);
          }
        });
  }
}
