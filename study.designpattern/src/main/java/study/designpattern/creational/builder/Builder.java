package study.designpattern.creational.builder;

interface Builder {
  void buildPartA();
  void buildPartB();
  ComplexObject getResult();
}
