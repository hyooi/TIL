package study.designpattern.creational.abstractfactory.basic1;

class Client {

  private ProductA productA;
  private ProductB productB;
  private AbstractFactory factory;

  Client(AbstractFactory factory) {
    this.factory = factory;
  }

  String operation() {
    System.out.println("Client : Delegating creating objects to a factory object.");
    productA = factory.createProductA();
    productB = factory.createProductB();

    return "Hello World from " + productA.getName() + " and " + productB.getName() + "!";
  }
}
