package study.designpattern.structural.proxy;

abstract class Subject {

  abstract String operation();
}

class RealSubject extends Subject {

  String operation() {
    return "RealSubject!";
  }
}

class Proxy extends Subject {

  private RealSubject realSubject;

  Proxy(RealSubject subject) {
    this.realSubject = subject;
  }

  String operation() {
    return "Hello world from Proxy and " + realSubject.operation();
  }
}