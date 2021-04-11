package functionalinterface;

@FunctionalInterface
public interface MyFirstFunctionalInterface {

  void firstWork(); //functional interface는 단 하나의 추상메소드만 허용

  default void doSomeMoreWork1() {
  }

  @Override
  String toString();
  //object의 public 하위 메소드를 상속한 경우 추상메소드로 카운트되지 않음.
  // 인터페이스가 object 혹은 다른 곳에서 구현되므로

  @Override
  boolean equals(Object obj);
}
