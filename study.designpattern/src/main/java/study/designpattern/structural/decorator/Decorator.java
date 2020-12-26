package study.designpattern.structural.decorator;

abstract class Decorator extends Component {

  Component component;

  Decorator(Component component) {
    this.component = component;
  }

  String operation() {
    // Forwarding to component.
    return component.operation();
  }
}

class Decorator1 extends Decorator {

  Decorator1(Component component) {
    super(component); // calling the super class constructor
  }

  String operation() {
    // Forwarding to component.
    String result = super.operation();
    // Adding functionality to result from component.
    return addBehavior(result);
  }

  private String addBehavior(String result) {
    return "***" + result + "***";
  }
}

class Decorator2 extends Decorator {

  Decorator2(Component component) {
    super(component); // calling the super class constructor
  }

  String operation() {
    // Forwarding to component.
    String result = super.operation();
    // Adding functionality to result from component.
    return addBehavior(result);
  }

  private String addBehavior(String result) {
    return " === " + result + " === ";
  }
}