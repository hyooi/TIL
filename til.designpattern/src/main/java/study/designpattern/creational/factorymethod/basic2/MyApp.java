package study.designpattern.creational.factorymethod.basic2;

class MyApp {

  public static void main(String[] args) {
    System.out.println(Creator1.factoryMethod().getName() + " created.");
    System.out.println(Creator2.factoryMethod().getName() + " created.");
  }
}
