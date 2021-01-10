package study.designpattern.creational.prototype.basic2;

class MyApp {

  public static void main(String[] args) {
    Client client = new Client(new PrototypeFactory(new ProductA1("ProductA1"),
        new ProductB1("ProductB1")));

    System.out.println(client.operation());
  }
}
