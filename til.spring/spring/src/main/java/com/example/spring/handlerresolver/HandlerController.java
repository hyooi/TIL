package com.example.spring.handlerresolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerController {
  private static final Logger logger = LoggerFactory.getLogger(HandlerController.class);

  @GetMapping("/handler")
  public void test(@RequestParam CriteriaDto dto) {
    logger.info("arg1: {}", dto.getArg1());
    logger.info("arg2: {}", dto.getArg2());
  }
}
