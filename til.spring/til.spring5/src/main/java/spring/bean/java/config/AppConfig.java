package spring.bean.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
  @Bean
  public EmployeeManager employeeManager() {
    return new EmployeeManagerImpl();
  }
}
