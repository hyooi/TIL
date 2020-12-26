package study.designpattern.creational.abstractfactory.basic1;

interface ProductA {

  String getName();
}

class ProductA1 implements ProductA {

  @Override
  public String getName() {
    return "ProductA1";
  }
}

class ProductA2 implements ProductA {

  @Override
  public String getName() {
    return "ProductB1";
  }
}

