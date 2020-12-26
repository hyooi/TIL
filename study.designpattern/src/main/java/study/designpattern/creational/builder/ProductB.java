package study.designpattern.creational.builder;

interface ProductB extends Product {

}

class ProductB1 implements ProductB {

  @Override
  public String getName() {
    return "ProductB1";
  }
}
