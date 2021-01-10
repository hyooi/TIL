package study.designpattern.structural.bridge;

class MyApp {

  public static void main(String[] args) {
    Abstraction abstraction = new Abstraction1(new Implementor1());
    System.out.println(abstraction.operation());
  }
}
