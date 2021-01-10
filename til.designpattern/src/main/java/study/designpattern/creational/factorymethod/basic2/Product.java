package study.designpattern.creational.factorymethod.basic2;

interface Product {

  String getName();
}

class Product1 implements Product {

  @Override
  public String getName() {
    return "Product1";
  }
}

class Product2 implements Product {

  @Override
  public String getName() {
    return "Product2";
  }
}