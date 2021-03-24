package com.spring.webflux.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
@ToString
public class Employee {
  private @Id int id;
  private String name;
  private long salary;

}
