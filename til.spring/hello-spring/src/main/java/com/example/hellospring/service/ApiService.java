package com.example.hellospring.service;

import com.example.hellospring.controller.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiService {

  private final ApiRepository repository;

  public ApiService(ApiRepository repository) {
    this.repository = repository;
  }

  @Transactional(isolation = Isolation.READ_COMMITTED)
  public ApiDto save() {
    ApiDto result = new ApiDto();
    BeanUtils.copyProperties(repository.save(new Api("hyoin")), result);

    return result;
  }

  @Transactional(readOnly = true)
  public Iterable<Api> findAll() {
    return repository.findAll();
  }
}
