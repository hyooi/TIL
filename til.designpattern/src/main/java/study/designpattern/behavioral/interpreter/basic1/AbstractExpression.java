package study.designpattern.behavioral.interpreter.basic1;

abstract class AbstractExpression {

  private String name;

  AbstractExpression(String name) {
    this.name = name;
  }

  abstract void interpret(Context context);

  //
  String getName() {
    return name;
  }

  // Defining default implementation for child management operations.
  boolean add(AbstractExpression e) { // fail by default
    return false;
  }
}