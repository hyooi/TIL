package study.designpattern.behavioral.visitor;

abstract class Visitor {

  abstract void visitElementA(ElementA e);

  abstract void visitElementB(ElementB e);
}

class Visitor1 extends Visitor {

  void visitElementA(ElementA element) {
    System.out.println("Visitor1: Visiting (doing something on) ElementA.\n"
        + element.operationA());
  }

  void visitElementB(ElementB element) {
    System.out.println("Visitor1: Visiting (doing something on) ElementB.\n"
        + element.operationB());
  }
}