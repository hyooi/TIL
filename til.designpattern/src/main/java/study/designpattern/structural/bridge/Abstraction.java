package study.designpattern.structural.bridge;

interface Abstraction {

  String operation();
}

class Abstraction1 implements Abstraction {

  private Implementor imp;

  Abstraction1(Implementor imp) {
    this.imp = imp;
  }

  @Override
  public String operation() {
    return "Abstraction1: Delegating implementation to a implementor. "
        + imp.operationImp();
  }
}
