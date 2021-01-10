package study.designpattern.behavioral.interpreter.basic1;

import java.util.ArrayList;
import java.util.List;

class NonTerminalExpression extends AbstractExpression {

  private List<AbstractExpression> expressions = new ArrayList<AbstractExpression>();

  NonTerminalExpression(String name) {
    super(name);
  }

  void interpret(Context context) {
    System.out.println(getName() + ": ");
    for (AbstractExpression expression : expressions) {
      System.out.println(
          " interpreting ... " + expression.getName());
      expression.interpret(context);
    }
    System.out.println(getName() + " finished.");
  }

  // Overriding the default implementation.
  @Override
  boolean add(AbstractExpression e) {
    return expressions.add(e);
  }
}
