package com.example.hellospring.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends CrudRepository<Api, Integer> {

}
