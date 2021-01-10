package study.designpattern.behavioral.chainofresponsibility;

class Sender {

  // Running the Sender class as application.
  public static void main(String[] args) {
    // Creating the chain of handler objects.
    Handler handler = new Receiver1(new Receiver2(new Receiver3()));
    //
    System.out.println("Issuing a request to a handler object ... ");
    handler.handleRequest();
  }
}