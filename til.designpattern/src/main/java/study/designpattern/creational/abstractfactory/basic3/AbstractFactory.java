package study.designpattern.creational.abstractfactory.basic3;

abstract class AbstractFactory {

  private static AbstractFactory factory;

  static AbstractFactory getInstance() {
    if (factory == null) {
      factory = new Factory1();
    }

    return factory;
  }

  abstract ProductA createProductA();

  abstract ProductB createProductB();

  private static class Factory1 extends AbstractFactory {

    ProductA createProductA() {
      System.out.println(" creating a ProductA1 object ...");
      return new ProductA1();
    }

    ProductB createProductB() {
      System.out.println(" creating a ProductB1 object ...");
      return new ProductB1();
    }
  }

  private static class Factory2 extends AbstractFactory {

    @Override
    ProductA createProductA() {
      System.out.println(" creating a ProductA2 object ...");
      return new ProductA2();
    }

    @Override
    ProductB createProductB() {
      System.out.println(" creating a ProductB2 object ...");
      return new ProductB2();
    }

  }
}
