package study.designpattern.creational.abstractfactory.basic2;

class Client {

  public static void main(String[] args) {
    System.out.println("Creating an order object:");
    Factory1.createOrder();

    System.out.println("Creating a product object:");
    Factory1.createProduct();
  }
}
