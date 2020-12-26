package study.designpattern.structural.decorator;

abstract class Component {

  abstract String operation();
}

class Component1 extends Component {

  String operation() {
    return "Hello World from Component1!";
  }
}
