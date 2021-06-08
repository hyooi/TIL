public class MyAtmApplication {

  public void run(String[] args) throws InterruptedException {
    System.out.println("[Application] Starting ATM Application");
    MyAtm.withdrawMoney(Integer.parseInt(args[2]));

    Thread.sleep(Long.parseLong(args[1]));
    MyAtm.withdrawMoney(Integer.parseInt(args[3]));
  }
}
