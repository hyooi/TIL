package study.designpattern.behavioral.interpreter.basic2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class NonTerminalExpression extends Expression {

  private List<Expression> expressions = new ArrayList<Expression>();

  //
  abstract boolean evaluate(Context context);

  // Overriding the default implementation.
  @Override
  boolean add(Expression e) {
    return expressions.add(e);
  }

  @Override
  Iterator<Expression> iterator() {
    return expressions.iterator();
  }
}

class AndExpr extends NonTerminalExpression { // NonTerminal Expression

  boolean evaluate(Context context) {
    Iterator<Expression> it = iterator();
    while (it.hasNext()) {
      if (!it.next().evaluate(context)) {
        return false;
      }
    }
    return true;
  }
}

class OrExpr extends NonTerminalExpression { // NonTerminal Expression

  boolean evaluate(Context context) {
    Iterator<Expression> it = iterator();
    while (it.hasNext()) {
      if (it.next().evaluate(context)) {
        return true;
      }
    }
    return false;
  }
}

class NotExpr extends NonTerminalExpression { // NonTerminal Expression

  boolean evaluate(Context context) {
    Iterator<Expression> it = iterator();
    while (it.hasNext()) {
      if (it.next().evaluate(context)) {
        return false;
      }
    }
    return true;
  }
}