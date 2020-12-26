package study.designpattern.creational.prototype.basic2;

class PrototypeFactory {

  private ProductA productA;
  private ProductB productB;

  PrototypeFactory(ProductA pa, ProductB pb) {
    this.productA = pa;
    this.productB = pb;
  }

  ProductA createProductA() {
    System.out.println("PrototypeFactory: Cloning a ProductA object");
    return productA.clone();
  }

  ProductB createProductB() {
    System.out.println("PrototypeFactory: Cloning a ProductB object.");
    return productB.clone();
  }
}
