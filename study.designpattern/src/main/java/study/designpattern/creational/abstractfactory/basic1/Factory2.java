package study.designpattern.creational.abstractfactory.basic1;

class Factory2 implements AbstractFactory {

  @Override
  public ProductA createProductA() {
    System.out.println("Factory2: Creating a ProductA1 object.");
    return new ProductA1();
  }

  @Override
  public ProductB createProductB() {
    System.out.println("Factory2: Creating a ProductB1 object.");
    return new ProductB1();
  }
}
