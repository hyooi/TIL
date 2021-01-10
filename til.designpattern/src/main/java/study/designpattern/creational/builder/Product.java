package study.designpattern.creational.builder;

interface Product {

  String getName();
}

interface ProductA extends Product {

}

class ProductA1 implements Product {

  @Override
  public String getName() {
    return "ProductA1";
  }
}
