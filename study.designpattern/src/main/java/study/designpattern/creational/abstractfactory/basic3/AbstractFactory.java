package study.designpattern.creational.abstractfactory.basic3;

abstract class AbstractFactory {
  private static AbstractFactory factory;
  public static AbstractFactory getInstance() {
    if(factory == null) {
      factory = new Factory1();
    }

    return factory;
  }

  public abstract ProductA createProductA();
  public abstract ProductB createProductB();

  private static class Factory1 extends AbstractFactory {
    public ProductA createProductA() {
      System.out.println(" creating a ProductA1 object ...");
      return new ProductA1();
    }

    public ProductB createProductB() {
      System.out.println(" creating a ProductB1 object ...");
      return new ProductB1();
    }
  }

  private static class Factory2 extends AbstractFactory {

    @Override
    public ProductA createProductA() {
      System.out.println(" creating a ProductA2 object ...");
      return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        System.out.println(" creating a ProductB2 object ...");
        return new ProductB2();
    }

  }
}
