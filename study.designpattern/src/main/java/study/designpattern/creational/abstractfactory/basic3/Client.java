package study.designpattern.creational.abstractfactory.basic3;

class Client {

  public static void main(String[] args) {
    AbstractFactory factory = AbstractFactory.getInstance();

    System.out.println("Creating a family of objects:");
    factory.createProductA();
    factory.createProductB();
    System.out.println("Family of objects created.");
  }
}
