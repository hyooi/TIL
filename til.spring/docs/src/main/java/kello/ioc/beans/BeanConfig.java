package kello.ioc.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public FactoryMethodDao factoryMethodDao() {
    return FactoryMethodDao.instance();
  }

  @Bean
  public InstanceFactoryMethodDao instanceFactoryMethodDao() {
    return new InstanceFactoryMethodDao();
  }

  @Bean
  public ConstructorService constructorService() {
    return new ConstructorService(factoryMethodDao(), 1000);
  }
}
