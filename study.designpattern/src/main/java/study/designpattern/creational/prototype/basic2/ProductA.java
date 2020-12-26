package study.designpattern.creational.prototype.basic2;

interface ProductA {

  String getName();

  ProductA clone();
}

class ProductA1 implements ProductA {

  private String name;

  ProductA1(String name) {
    this.name = name;
  }

  ProductA1(ProductA1 pa) {
    this.name = pa.getName();
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public ProductA clone() {
    return new ProductA1(this);
  }
}