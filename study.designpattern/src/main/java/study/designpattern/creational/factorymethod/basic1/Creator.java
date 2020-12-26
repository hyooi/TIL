package study.designpattern.creational.factorymethod.basic1;

abstract class Creator {

  private Product product;

  abstract Product factoryMethod();

  String operation() {
    product = factoryMethod();
    return "Hello world from " + this.getClass().getSimpleName() + "!\n"
        + product.getName() + " created.";
  }
}

class Creator1 extends Creator {

  Product factoryMethod() {
    return new Product1();
  }
}
