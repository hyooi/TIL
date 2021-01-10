package study.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {

  private List<Observer> observers = new ArrayList<Observer>();

  void attach(Observer o) {
    observers.add(o);
  }

  void notifyObservers() {
    for (Observer o : observers) {
      o.update();
    }
  }
}

class Subject1 extends Subject {

  private int state = 0;

  int getState() {
    return state;
  }

  void setState(int state) {
    this.state = state;
    System.out.println(
        "Subject1 : State changed to : " + state +
            "\n Notifying observers ...");
    notifyObservers();
  }
}