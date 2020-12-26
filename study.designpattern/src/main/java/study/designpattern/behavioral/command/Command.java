package study.designpattern.behavioral.command;

interface Command {

  void execute();
}

class Command1 implements Command {

  private Receiver1 receiver1;

  Command1(Receiver1 receiver1) {
    this.receiver1 = receiver1;
  }

  @Override
  public void execute() {
    System.out.println("Command1 : Performing (carrying out) the request ...");
    receiver1.action1();
  }
}
