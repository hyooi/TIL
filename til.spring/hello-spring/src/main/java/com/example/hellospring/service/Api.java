package com.example.hellospring.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Api {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  public Api(String name) {
    this.name = name;
  }

  public Api() {

  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Api{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
