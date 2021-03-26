package com.spring.webflux.controller;

import com.spring.webflux.model.Employee;
import java.time.Duration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

  private final WebClient webClient;

  public WebClientController(WebClient webClient) {
    this.webClient = webClient;
  }

  @GetMapping("/test1")
  public Flux<Employee> findAll() {
    return webClient.get()
        .uri("/employees")
        .retrieve()
        .bodyToFlux(Employee.class)
        .timeout(Duration.ofMillis(10000));
  }

  @GetMapping("/test2")
  public Mono<Employee> findById(Integer id) {
    return webClient.get()
        .uri("/employees/" + id)
        .retrieve()
        .onStatus(HttpStatus.NOT_FOUND::equals,
            clientResponse -> Mono.empty())
        .bodyToMono(Employee.class)
        .timeout(Duration.ofMillis(10000));
  }

  @GetMapping("/test3")
  public Mono<Employee> create(Employee employee) {
    return webClient.post()
        .uri("/employees")
        .body(Mono.just(employee), Employee.class)
        .retrieve()
        .bodyToMono(Employee.class);
  }

  @GetMapping("/test4")
  public Mono<Employee> update(Employee e) {
    return webClient.put()
        .uri("/employees" + e.getId())
        .body(Mono.just(e), Employee.class)
        .retrieve()
        .bodyToMono(Employee.class);
  }

  @GetMapping("/test5")
  public Mono<Void> delete(Integer id) {
    return webClient.delete()
        .uri("/employees" + id)
        .retrieve()
        .bodyToMono(Void.class);
  }
}
