package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

  @LocalServerPort
  private int port;

  @Test
  public void givenAppStarted_whenNotificationTasksSubmitted_thenProcessed() {
    var restTemplate = new RestTemplate();
    restTemplate.getForObject("http://localhost:" + port + "/startNotification/10", String.class);
  }
}
