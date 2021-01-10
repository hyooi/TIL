package study.designpattern.behavioral.command;

class MyApp {

  public static void main(String[] args) {
    // Creating an Invoker object
    // and configuring it with a Command1 object.
    Invoker invoker = new Invoker(new Command1(new Receiver1()));
    // Calling an operation on invoker.
    invoker.operation();
  }
}