package study.designpattern.creational.prototype.basic2;

interface ProductB {

  String getName();

  ProductB clone();
}

class ProductB1 implements ProductB {

  private String name;

  ProductB1(String name) {
    this.name = name;
  }

  ProductB1(ProductB1 pa) {
    this.name = pa.getName();
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public ProductB clone() {
    return new ProductB1(this);
  }
}