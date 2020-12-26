package study.designpattern.behavioral.interpreter.basic2;

import java.util.Collections;
import java.util.Iterator;

abstract class Expression {

  abstract boolean evaluate(Context context);

  // Defining default implementation for child management operations.
  boolean add(Expression e) { // fail by default
    return false;
  }

  Iterator<Expression> iterator() {
    return Collections.emptyIterator(); // null iterator
  }
}

class VarExpr extends Expression { // Terminal Expression

  private String name;

  VarExpr(String name) {
    this.name = name;
  }

  // Getting true or false from context.
  boolean evaluate(Context context) {
    return context.getVarExpr(name);
  }

  String getName() {
    return name;
  }
}


