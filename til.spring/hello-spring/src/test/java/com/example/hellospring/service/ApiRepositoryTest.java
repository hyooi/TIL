package com.example.hellospring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ApiRepositoryTest {
  @Autowired
  private ApiRepository repository;

  @Test
  void test() {
    repository.findAll();
  }
}