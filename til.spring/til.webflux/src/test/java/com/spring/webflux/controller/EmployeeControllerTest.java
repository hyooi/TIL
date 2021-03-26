package com.spring.webflux.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import com.spring.webflux.model.Employee;
import com.spring.webflux.repository.EmployeeRepository;
import com.spring.webflux.service.EmployeeService;
import java.util.Collections;
import java.util.List;
import lombok.val;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
    //WebFluxTest를 통해 어플리케이션 컨텍스트에 자동으로 주입되지 않는 빈 스캔
class EmployeeControllerTest {

  @MockBean
  private EmployeeRepository repository;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testCreateEmployee() {
    val name = RandomStringUtils.randomAlphanumeric(10);
    Employee employee = new Employee(1, name, 1000);

    given(repository.save(any(Employee.class)))
        .willReturn(Mono.just(employee));

    webTestClient.post()
        .uri("/create")
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(employee))
        .exchange()
        .expectStatus().isCreated();

    then(repository).should(times(1))
        .save(argThat(empl -> empl.getId() == 1
            && empl.getName().equals(name)
            && empl.getSalary() == 1000)
        );
  }

  @Test
  void testGetEmployeesByName() {
    val name = RandomStringUtils.randomAlphanumeric(10);
    Employee employee = new Employee(1, name, 1000);

    List<Employee> list = Collections.singletonList(employee);
    Flux<Employee> employeeFlux = Flux.fromIterable(list);

    given(repository.findByName(name))
        .willReturn(employeeFlux);

    webTestClient.get()
        .uri("/name/{name}", name)
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(Employee.class);

    then(repository).should(times(1))
        .findByName(name);
  }

  @Test
  void testGetEmployeeById() {
    val name = RandomStringUtils.randomAlphanumeric(10);
    Employee employee = new Employee(100, name, 1000);

    given(repository.findById(100))
        .willReturn(Mono.just(employee));

    webTestClient.get()
        .uri("/{id}", 100)
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.name").isNotEmpty()
        .jsonPath("$.id").isEqualTo(100)
        .jsonPath("$.name").isEqualTo(name)
        .jsonPath("$.salary").isEqualTo(1000);

    then(repository).should(times(1))
        .findById(100);
  }

  @Test
  void testDeleteEmployee() {
    Mono<Void> voidReturn = Mono.empty();

    given(repository.deleteById(1))
        .willReturn(voidReturn);

    webTestClient.delete().uri("/delete/{id}", 1)
        .exchange()
        .expectStatus().isOk();
  }
}