package study.designpattern.behavioral.strategy;

class MyApp {

  public static void main(String[] args) {
    Context context = new Context(new Strategy1());
    System.out.println("(1) " + context.operation());

    context.setStrategy(new Strategy2());
    System.out.println("(2) " + context.operation());
  }
}