package com.example.spring.handlerresolver;

import lombok.Getter;

@Getter
public class CriteriaDto {
  private String arg1;
  private String arg2;

  public CriteriaDto(String arg1, String arg2) {
    this.arg1 = arg1;
    this.arg2 = arg2;
  }
}
