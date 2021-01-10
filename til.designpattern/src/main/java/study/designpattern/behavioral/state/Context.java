package study.designpattern.behavioral.state;

class Context {

  private State state; // reference to the current State object

  Context(State state) {
    this.state = state;
  }

  String operation() {
    return
        "Context: Delegating state-specific behavior to the current State object.\n"
            + state.operation(this);
  }

  void setState(State state) { // package private
    this.state = state;
  }
}