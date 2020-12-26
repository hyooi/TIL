package study.designpattern.structural.flyweight;

interface Flyweight {

  String operation(int extrinsicState);
}

class Flyweight1 implements Flyweight {

  private String intrinsicState;

  Flyweight1(String intrinsicState) {
    this.intrinsicState = intrinsicState;
  }

  @Override
  public String operation(int extrinsicState) {
    return " performing an operation on the flyweight\n "
        + " with intrinsic state = " + intrinsicState
        + " and passed in extrinsic state = " + extrinsicState + ".";
  }
}