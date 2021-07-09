package com.example.hellospring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApiService.class)
class ApiServiceTest {

  @Autowired
  private ApiService service;

  @MockBean
  private ApiRepository repository;

  @Test
  void save() {
    given(repository.save(any()))
        .willReturn(new Api("test"));
    service.save();
  }

  @Test
  void findAll() {
    service.findAll();
  }
}