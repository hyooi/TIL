package study.designpattern.behavioral.memento;

class Originator {

  private String state;

  Memento createMemento() {
    Memento memento = new Memento();
    memento.setState(state);
    return memento;
  }

  void restore(Memento memento) {
    state = memento.getState();
  }

  String getState() {
    return state;
  }

  void setState(String state) {
    this.state = state;
  }

  class Memento {

    private String state;

    private String getState() {
      return state;
    }

    private void setState(String state) {
      this.state = state;
    }
  }
}