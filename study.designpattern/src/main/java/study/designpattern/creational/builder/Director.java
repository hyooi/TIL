package study.designpattern.creational.builder;

class Director {
  private ComplexObject co;
  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public String construct() {
    System.out.println("Director: Delegating constructing a complex object to a builder object.");
    builder.buildPartA();
    builder.buildPartB();
    co = builder.getResult();

    return "Hello World from " + co.getParts() + " objects!";
  }
}
