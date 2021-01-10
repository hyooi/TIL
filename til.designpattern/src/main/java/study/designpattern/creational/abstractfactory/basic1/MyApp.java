package study.designpattern.creational.abstractfactory.basic1;

class MyApp {

  public static void main(String[] args) {
    Client client = new Client(new Factory1());
    System.out.println(client.operation());
  }
}
