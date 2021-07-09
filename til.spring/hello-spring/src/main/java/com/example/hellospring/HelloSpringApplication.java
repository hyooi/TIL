package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class HelloSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloSpringApplication.class, args);
  }

}
