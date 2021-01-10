package study.designpattern.behavioral.state;

interface State {

  String operation(Context context);
}

class State1 implements State {

  private static final State1 INSTANCE = new State1();

  private State1() {
  }

  static State1 getInstance() {
    return INSTANCE;
  }

  @Override
  public String operation(Context context) {
    String result = " State1 : Hello World1!" +
        " Changing current state of Context to State2.";
    context.setState(State2.getInstance()); // state transition
    return result;
  }
}

class State2 implements State {

  private static final State2 INSTANCE = new State2();

  private State2() {
  }

  static State2 getInstance() {
    return INSTANCE;
  }

  @Override
  public String operation(Context context) {
    String result = " State2 : Hello World2!" +
        " Changing current state of Context to State1.";
    context.setState(State1.getInstance()); // state transition
    return result;
  }
}