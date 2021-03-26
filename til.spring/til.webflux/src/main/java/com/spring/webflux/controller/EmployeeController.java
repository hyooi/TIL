package com.spring.webflux.controller;

import com.spring.webflux.model.Employee;
import com.spring.webflux.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

  private final IEmployeeService employeeService;

  public EmployeeController(IEmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping(value = {"/create", "/"})
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Employee e) {
    employeeService.create(e);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
    Mono<Employee> e = employeeService.findById(id);
    HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

    return new ResponseEntity<>(e, status);
  }

  @GetMapping("/name/{name}")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Employee> findByName(@PathVariable("name") String name) {
    return employeeService.findByName(name);
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Employee> findAll() {
    return employeeService.findAll();
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Employee> update(@RequestBody Employee e) {
    return employeeService.update(e);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Integer id) {
    employeeService.delete(id).subscribe();
  }
}
