import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spring.webflux.WebfluxFunctionalApp;
import com.spring.webflux.model.Employee;
import com.spring.webflux.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = WebfluxFunctionalApp.class)
public class WebfluxTest {

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void findAll() {
    repository.save(new Employee(1, "name1", 1000)).block();
    Flux<Employee> employeeFlux = repository.findAll();

    StepVerifier
        .create(employeeFlux)
        .assertNext(employee -> {
          assertEquals(1, employee.getId());
          assertEquals("name1", employee.getName());
          assertEquals(1000L, employee.getSalary());
        })
        .expectComplete()
        .verify();
  }

  @Test
  public void findById() {
    repository.save(new Employee(1, "name1", 1000)).block();
    Mono<Employee> employeeMono = repository.findById(1);

    StepVerifier
        .create(employeeMono)
        .assertNext(employee -> {
          assertEquals(1, employee.getId());
          assertEquals("name1", employee.getName());
          assertEquals(1000L, employee.getSalary());
        })
        .expectComplete()
        .verify();
  }

}
