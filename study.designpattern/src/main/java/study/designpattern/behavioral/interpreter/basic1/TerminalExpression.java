package study.designpattern.behavioral.interpreter.basic1;

class TerminalExpression extends AbstractExpression {

  TerminalExpression(String name) {
    super(name);
  }

  void interpret(Context context) {
    // ...
  }
}