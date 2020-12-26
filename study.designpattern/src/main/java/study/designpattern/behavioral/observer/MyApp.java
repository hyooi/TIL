package study.designpattern.behavioral.observer;

class MyApp {

  public static void main(String[] args) {
    Subject1 s1 = new Subject1();
    Observer o1 = new Observer1(s1);
    Observer o2 = new Observer2(s1);

    System.out.println("Changing state of Subject1 ...");
    s1.setState(100);
  }
}