package study.designpattern.behavioral.command;

class Invoker {

  private Command command;

  Invoker(Command command) {
    this.command = command;
  }

  public void operation() {
    System.out
        .println("Invoker : Calling execute on the installed command ... ");
    command.execute();
  }
}