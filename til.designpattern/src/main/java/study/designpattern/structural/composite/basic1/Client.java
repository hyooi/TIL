package study.designpattern.structural.composite.basic1;

class Client {

  public static void main(String[] args) {
    Component composite2 = new Composite("composite2 ");
    composite2.add(new Leaf("leaf3 "));
    composite2.add(new Leaf("leaf4 "));
    composite2.add(new Leaf("leaf5 "));

    Component composite1 = new Composite("composite1 ");
    composite1.add(new Leaf("leaf1 "));
    composite1.add(composite2);
    composite1.add(new Leaf("leaf2 "));

    System.out.println("(1) " + composite1.operation());
    System.out.println("(2) " + composite2.operation());
  }
}
