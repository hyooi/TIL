package study.designpattern.behavioral.observer;

abstract class Observer {

  abstract void update();
}

class Observer1 extends Observer {

  private int state;
  private Subject1 subject;

  public Observer1(Subject1 subject) {
    this.subject = subject;
    subject.attach(this);
  }

  void update() {
    this.state = subject.getState();
    System.out.println(
        "Observer1: State updated to : " + this.state);
  }
}

class Observer2 extends Observer {

  private int state;
  private Subject1 subject;

  Observer2(Subject1 subject) {
    this.subject = subject;
    subject.attach(this);
  }

  void update() {
    this.state = subject.getState();
    System.out.println(
        "Observer2: State updated to : " + this.state);
  }
}