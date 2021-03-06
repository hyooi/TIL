package study.designpattern.creational.abstractfactory.basic1;

class FactoryMock implements AbstractFactory {

  @Override
  public ProductA createProductA() {
    return new ProductAMock();
  }

  @Override
  public ProductB createProductB() {
    return new ProductBMock();
  }
}
