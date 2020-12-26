package study.designpattern.creational.factorymethod.basic1;

interface Product {

  String getName();
}

class Product1 implements Product {

  public String getName() {
    return "Product1";
  }
}

class Product2 implements Product {

  public String getName() {
    return "Product2";
  }
}
