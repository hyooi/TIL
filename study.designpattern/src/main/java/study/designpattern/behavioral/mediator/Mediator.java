package study.designpattern.behavioral.mediator;

abstract class Mediator {

  abstract void mediate(Colleague colleague);
}

class Mediator1 extends Mediator {

  private Colleague1 colleague1;
  private Colleague2 colleague2;

  void setColleagues(Colleague1 colleague1, Colleague2 colleague2) {
    this.colleague1 = colleague1;
    this.colleague2 = colleague2;
  }

  void mediate(Colleague colleague) {
    System.out.println(" Mediator : Mediating the interaction ...");
    if (colleague == colleague1) {
      String state = colleague1.getState();
      colleague2.action2(state);
    }
    if (colleague == colleague2) {
      String state = colleague2.getState();
      colleague1.action1(state);
    }
  }
}