package study.designpattern.creational.abstractfactory.basic1;

interface ProductB {

  String getName();
}

class ProductB1 implements ProductB {

  @Override
  public String getName() {
    return "ProductB1";
  }
}

class ProductB2 implements ProductB {

  @Override
  public String getName() {
    return "ProductB1";
  }
}
