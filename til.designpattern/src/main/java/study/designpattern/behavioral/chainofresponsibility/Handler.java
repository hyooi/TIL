package study.designpattern.behavioral.chainofresponsibility;

abstract class Handler {

  private Handler successor;

  Handler() {
  }

  Handler(Handler successor) {
    this.successor = successor;
  }

  void handleRequest() {
    // Forwarding to successor (if any).
    if (successor != null) {
      successor.handleRequest();
    }
  }

  boolean canHandleRequest() {
    // Checking run-time conditions ...
    return false;
  }
}

class Receiver1 extends Handler {

  Receiver1(Handler successor) {
    super(successor);
  }

  @Override
  void handleRequest() {
    if (canHandleRequest()) {
      System.out.println("Receiver1: Handling the request ...");
    } else {
      System.out.println("Receiver1: Passing the request along the chain ...");
      super.handleRequest();
    }
  }
}

class Receiver2 extends Handler {

  Receiver2(Handler successor) {
    super(successor);
  }

  @Override
  void handleRequest() {
    if (canHandleRequest()) {
      System.out.println("Receiver2: Handling the request ...");
    } else {
      System.out.println("Receiver2: Passing the request along the chain ...");
      super.handleRequest();
    }
  }
}

class Receiver3 extends Handler {

  @Override
  void handleRequest() {
    // Must handle the request unconditionally.
    System.out.println("Receiver3: Handling the request.");
  }
}