package study.designpattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;
import study.designpattern.behavioral.memento.Originator.Memento;

class Caretaker {

  public static void main(String[] args) {
    Originator originator = new Originator();
    Originator.Memento memento; // Memento is inner class of Originator

    List<Memento> mementos = new ArrayList<Memento>();
    originator.setState("A");
    memento = originator.createMemento();
    mementos.add(memento); // adding to list
    System.out.println("(1) Saving current state ...... : "
        + originator.getState());

    originator.setState("B");
    memento = originator.createMemento();
    mementos.add(memento); // adding to list
    System.out.println("(2) Saving current state ...... : "
        + originator.getState());

    memento = mementos.get(0); // getting previous (first) memento from the list
    originator.restore(memento);
    System.out.println("(3) Restoring to previous state : "
        + originator.getState());
  }
}