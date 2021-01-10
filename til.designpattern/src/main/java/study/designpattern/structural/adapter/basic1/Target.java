package study.designpattern.structural.adapter.basic1;

interface Target {

  String operation();
}

class ObjectAdapter implements Target {

  private Adaptee adaptee;

  ObjectAdapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public String operation() {
    return adaptee.specificOperation();
  }
}

class ClassAdapterAdaptee extends Adaptee implements Target {

  @Override
  public String operation() {
    return specificOperation();
  }
}