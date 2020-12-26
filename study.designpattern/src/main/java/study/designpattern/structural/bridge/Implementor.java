package study.designpattern.structural.bridge;

interface Implementor {

  String operationImp();
}

class Implementor1 implements Implementor {

  public String operationImp() {
    return "Implementor1: Hello World!";
  }
}
