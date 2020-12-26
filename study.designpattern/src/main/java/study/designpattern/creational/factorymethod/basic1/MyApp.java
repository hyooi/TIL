package study.designpattern.creational.factorymethod.basic1;

class MyApp {

  public static void main(String[] args) {
    Creator creator = new Creator1();
    System.out.println(creator.operation());
  }
}
