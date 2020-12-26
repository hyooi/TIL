package study.designpattern.behavioral.interpreter.basic1;

class Client {

  // Running the Client class as application.
  public static void main(String[] args) throws Exception {
    // Building an abstract syntax tree (AST).
    AbstractExpression ntExpr2 = new NonTerminalExpression("ntExpr2");
    ntExpr2.add(new TerminalExpression(" tExpr3"));
    ntExpr2.add(new TerminalExpression(" tExpr4"));
    ntExpr2.add(new TerminalExpression(" tExpr5"));
    AbstractExpression ntExpr1 = new NonTerminalExpression("ntExpr1");
    ntExpr1.add(new TerminalExpression(" tExpr1"));
    ntExpr1.add(ntExpr2);
    ntExpr1.add(new TerminalExpression(" tExpr2"));
    Context context = new Context();
    // Interpreting the AST (walking the tree).
    ntExpr1.interpret(context);
  }
}