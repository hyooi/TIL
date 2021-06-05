package com.example.spring.cache;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring.cache.Customer;
import com.example.spring.cache.CustomerDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerDataServiceTest {

  private @Autowired
  CustomerDataService service;

  @Test
  void getAddress() {
    var customer = new Customer("name0", "address0");
    var result = service.getAddress(customer);
    assertThat(result).isEqualTo("address0");

    result = service.getAddress(customer);
    assertThat(result).isEqualTo("address0");
  }

  @Test
  void getAddress2() {
    var customer = new Customer("name0", "address0");
    var result = service.getAddress2(customer);
    assertThat(result).isEqualTo("address0");

    result = service.getAddress2(customer);
    assertThat(result).isEqualTo("address0");
  }

  @Test
  void getAddress3() {
    var customer = new Customer("name0", "address0");
    var result = service.getAddress3(customer);
    assertThat(result).isEqualTo("address0");

    result = service.getAddress3(customer);
    assertThat(result).isEqualTo("address0");
  }

  @Test
  void getAddress5() {
    var customer = new Customer("name0", "address0");
    var result = service.getAddress5(customer);
    assertThat(result).isEqualTo("address0");

    result = service.getAddress5(customer);
    assertThat(result).isEqualTo("address0");

    var customer2 = new Customer("Tom", "address1");
    var result2 = service.getAddress5(customer2);
    assertThat(result2).isEqualTo("address1");

    result2 = service.getAddress5(customer2);
    assertThat(result2).isEqualTo("address1");
  }

  @Test
  void getAddress6() {
    var customer = new Customer("name0", "address0");
    var result = service.getAddress6(customer);
    assertThat(result).isEqualTo("address0");

    result = service.getAddress6(customer);
    assertThat(result).isEqualTo("address0");

    var customer2 = new Customer("Tom", "address111111111111111111");
    var result2 = service.getAddress6(customer2);
    assertThat(result2).isEqualTo("address111111111111111111");

    result2 = service.getAddress6(customer2);
    assertThat(result2).isEqualTo("address111111111111111111");
  }
}