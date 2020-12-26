package study.designpattern.creational.prototype.basic1;

class MyApp {

  public static void main(String[] args) {
    Client client = new Client(new Product1("Product1"));
    System.out.println(client.operation());
  }
}
