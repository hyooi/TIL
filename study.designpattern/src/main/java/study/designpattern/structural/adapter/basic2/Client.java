package study.designpattern.structural.adapter.basic2;

class Client {

  public static void main(String[] args) {
    Strategy strategy = new Strategy1();
    System.out.println("(1) " + strategy.algorithm());

    strategy = new Adapter(new Adaptee());
    System.out.println("(2) " + strategy.algorithm());
  }
}
