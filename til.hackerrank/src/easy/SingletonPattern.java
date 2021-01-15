package easy;

public class SingletonPattern {

  private static SingletonPattern SINGLETON = new SingletonPattern();
  private SingletonPattern() {}

  public String str;

  public static SingletonPattern getSingleInstance() {
    return SINGLETON;
  }
}
