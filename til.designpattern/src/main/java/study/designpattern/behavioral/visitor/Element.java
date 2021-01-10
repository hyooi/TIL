package study.designpattern.behavioral.visitor;

abstract class Element {

  abstract void accept(Visitor visitor);
}

class ElementA extends Element {

  void accept(Visitor visitor) {
    visitor.visitElementA(this);
  }

  String operationA() {
    return "Hello World from ElementA!";
  }
}

class ElementB extends Element {

  void accept(Visitor visitor) {
    visitor.visitElementB(this);
  }

  String operationB() {
    return "Hello World from ElementB!";
  }
}