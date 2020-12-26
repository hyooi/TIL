package study.designpattern.behavioral.templatemethod;

abstract class AbstractClass {

  protected abstract void primitive1();

  protected abstract void primitive2();

  final void templateMethod() {
    primitive1();
    primitive2();
  }
}

class SubClass1 extends AbstractClass {

  protected void primitive1() {
  }

  protected void primitive2() {
  }
}