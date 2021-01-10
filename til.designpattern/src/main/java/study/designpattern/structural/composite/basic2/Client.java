package study.designpattern.structural.composite.basic2;

class Client {

  public static void main(String[] args) {
    Component mainboard = new Mainboard("Mainboard", 100);
    mainboard.add(new Processor("Processor", 100));
    mainboard.add(new Memory("Memory", 100));

    Component chassis = new Chassis("Chassis ", 100);
    chassis.add(mainboard);
    chassis.add(new Disk("Disk ", 100));

    System.out
        .println(chassis.getName() + " total price: " + chassis.getPrice());
    System.out
        .println(mainboard.getName() + " total price: " + mainboard.getPrice());
  }
}
