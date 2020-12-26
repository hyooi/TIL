package study.designpattern.structural.decorator;

class Client {

  // Running the Client class as application.
  public static void main(String[] args) {
    // Working with the component directly.
    Component component = new Component1();
    System.out.println("(1) " + component.operation());
    // Working through decorators.
    component = new Decorator1(new Decorator2(component));
    System.out.println("(2) " + component.operation());
  }
}
