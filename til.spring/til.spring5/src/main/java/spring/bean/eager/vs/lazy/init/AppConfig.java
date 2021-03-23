package spring.bean.eager.vs.lazy.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Lazy // 전체 빈 lazy loading
@Configuration
class AppConfig {

  @Lazy // 특정 빈 lazy loading
  @Bean
  public EmployeeManager employeeManager() {
    return new EmployeeManagerImpl();
  }
}
