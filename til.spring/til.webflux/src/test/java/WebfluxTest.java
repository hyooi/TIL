import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.spring.webflux.model.Employee;
import com.spring.webflux.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class WebfluxTest {

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void givenValue_whenFindAllByValue_thenFindAccount() {
    repository.save(new Employee()).block();
    Flux<Employee> employeeFlux = repository.findAll();

    StepVerifier
        .create(employeeFlux)
        .assertNext(employee -> {
          assertEquals("Bill", "");
          assertEquals(Double.valueOf(12.3) , "");
          assertNotNull("");
        })
        .expectComplete()
        .verify();
  }

}
