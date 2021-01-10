package study.designpattern.behavioral.interpreter.basic2;

import java.util.HashMap;
import java.util.Map;

class Context {

  // Workspace for mapping VarExp name to true or false.
  Map<String, Boolean> varExprMap = new HashMap<String, Boolean>();

  //
  void setVarExpr(VarExpr v, boolean b) {
    varExprMap.put(v.getName(), b);
  }

  boolean getVarExpr(String name) {
    return varExprMap.get(name);
  }
}