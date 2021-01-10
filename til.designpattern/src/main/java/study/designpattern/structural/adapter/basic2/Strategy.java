package study.designpattern.structural.adapter.basic2;

interface Strategy {

  String algorithm();
}

class Strategy1 implements Strategy {

  @Override
  public String algorithm() {
    return "Working with Strategy1 to perform an algorithm!";
  }
}

class Adapter implements Strategy {

  private Adaptee adaptee;

  Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public String algorithm() {
    return adaptee.specificAlgorithm();
  }
}