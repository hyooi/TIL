package study.designpattern.creational.singleton;

class MyApp {

  public static void main(String[] args) {
    Singleton ref1 = null, ref2 = null;
    ref1 = Singleton.getInstance();
    ref2 = Singleton.getInstance();

    if (ref1 == ref2) {
      System.out.println("Singleton instantiated only once.");
    }
  }
}
