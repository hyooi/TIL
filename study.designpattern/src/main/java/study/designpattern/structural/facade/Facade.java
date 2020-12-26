package study.designpattern.structural.facade;

abstract class Facade {

  abstract String operation();
}

class Facade1 extends Facade {

  private Class1 object1;
  private Class2 object2;
  private Class3 object3;

  Facade1(Class1 object1, Class2 object2, Class3 object3) {
    this.object1 = object1;

    this.object2 = object2;
    this.object3 = object3;
  }

  String operation() {
    return "Facade forwards to ... "
        + object1.operation1()
        + object2.operation2()
        + object3.operation3();
  }
}