package study.designpattern.creational.prototype.basic1;

class Client {

  private Product product;
  private Prototype prototype;

  Client(Prototype prototype) {
    this.prototype = prototype;
  }

  String operation() {
    product = prototype.clone();
    return "Client: Cloning " + prototype.getClass().getSimpleName() + ".\n"
        + product.getName() + " object copied.";
  }
}
