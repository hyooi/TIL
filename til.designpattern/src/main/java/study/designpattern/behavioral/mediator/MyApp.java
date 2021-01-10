package study.designpattern.behavioral.mediator;

class MyApp {

  public static void main(String[] args) {
    Mediator1 mediator = new Mediator1();
    Colleague1 c1 = new Colleague1(mediator);
    Colleague2 c2 = new Colleague2(mediator);
    mediator.setColleagues(c1, c2);

    System.out.println("(1) Changing state of Colleague1 ...");
    c1.setState("Hello World1!");
    System.out.println("\n(2) Changing state of Colleague2 ...");
    c2.setState("Hello World2!");
  }
}