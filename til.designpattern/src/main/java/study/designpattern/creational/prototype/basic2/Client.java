package study.designpattern.creational.prototype.basic2;

class Client {

  private ProductA productA;
  private ProductB productB;
  private PrototypeFactory ptFactory;

  Client(PrototypeFactory ptFactory) {
    this.ptFactory = ptFactory;
  }

  String operation() {
    System.out
        .println("Client: Delegating object creation to a prototype factory");
    productA = ptFactory.createProductA();
    productB = ptFactory.createProductB();

    return "Hello World from " + productA.getName() + " and " + productB
        .getName() + "!";
  }
}