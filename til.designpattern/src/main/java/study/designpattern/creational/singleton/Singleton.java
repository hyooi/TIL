package study.designpattern.creational.singleton;

class Singleton {

  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {
  }

  static Singleton getInstance() {
    return INSTANCE;
  }
}
