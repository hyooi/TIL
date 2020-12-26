package study.designpattern.creational.abstractfactory.basic2;

class Factory1 {

  static Order createOrder() {
    System.out.println(" Order1 object created.");
    return new Order1();
  }

  static Product createProduct() {
    System.out.println(" Product1 object created.");
    return new Product1();
  }
}
