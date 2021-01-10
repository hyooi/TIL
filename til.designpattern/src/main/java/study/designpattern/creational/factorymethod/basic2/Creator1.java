package study.designpattern.creational.factorymethod.basic2;

class Creator1 {

  static Product factoryMethod() {
    return new Product1();
  }
}

class Creator2 extends Creator1 {

  static Product factoryMethod() {
    return new Product2();
  }
}