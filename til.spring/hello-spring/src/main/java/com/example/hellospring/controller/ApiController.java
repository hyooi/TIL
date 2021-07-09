package com.example.hellospring.controller;

import com.example.hellospring.service.Api;
import com.example.hellospring.service.ApiDto;
import com.example.hellospring.service.ApiService;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final ApiService service;

  public ApiController(ApiService service) {
    this.service = service;
  }

  @GetMapping("/{test}")
  public ResponseEntity<String> test(@PathVariable String test) {
    logger.debug("test!!");

    return ResponseEntity.ok()
        .header("test-header", "hyoin-header")
        .body("test"+ test);
  }

  @GetMapping("/putapi")
  public ResponseEntity<ApiDto> test2() {
    ApiDto result = service.save();
    logger.info("result: {}", result);

    return ResponseEntity.ok(result);
  }

  @GetMapping("/getapi")
  public ResponseEntity<Iterable<Api>> test3() {
    Iterable<Api> result = service.findAll();
    logger.info("result: {}", result);

    return ResponseEntity.ok(result);
  }
}
