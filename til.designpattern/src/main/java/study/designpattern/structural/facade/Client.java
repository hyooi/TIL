package study.designpattern.structural.facade;

class Client {

  // Running the Client class as application.
  public static void main(String[] args) {
    // Creating a facade for a subsystem.
    Facade facade = new Facade1
        (new Class1(), new Class2(), new Class3());
    // Working through the facade.
    System.out.println(facade.operation());
  }
}