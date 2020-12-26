package study.designpattern.behavioral.mediator;

abstract class Colleague {

  Mediator mediator;

  Colleague(Mediator mediator) {
    this.mediator = mediator;
  }
}

class Colleague1 extends Colleague {

  private String state;

  Colleague1(Mediator mediator) {
    super(mediator); // Calling the super class constructor
  }

  String getState() {
    return state;
  }

  void setState(String state) {
    if (state != this.state) {
      this.state = state;
      System.out.println(" Colleague1: My state changed to: "
          + this.state + " Calling my mediator ...");
      mediator.mediate(this);
    }
  }

  void action1(String state) {
    this.state = state;
    System.out.println(" Colleague1: My state synchronized to: "
        + this.state);
  }
}

class Colleague2 extends Colleague {

  private String state;

  Colleague2(Mediator mediator) {
    super(mediator);
  }

  String getState() {
    return state;
  }

  void setState(String state) {
    if (state != this.state) {
      this.state = state;
      System.out.println(" Colleague2: My state changed to: "
          + this.state + " Calling my mediator ...");
      mediator.mediate(this);
    }
  }

  void action2(String state) {
    this.state = state;
    System.out.println(" Colleague2: My state synchronized to: "
        + this.state);
  }
}