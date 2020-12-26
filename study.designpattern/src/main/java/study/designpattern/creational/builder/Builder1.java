package study.designpattern.creational.builder;

class Builder1 implements Builder {

  private ComplexObject co = new ComplexObject();

  @Override
  public void buildPartA() {
    System.out.println("Builder1: Creating and assembling ProductA1.");
    co.add(new ProductA1());
  }

  @Override
  public void buildPartB() {
    System.out.println("Builder1: Creating and assembling ProductB1.");
    co.add(new ProductB1());
  }

  @Override
  public ComplexObject getResult() {
    return co;
  }
}
