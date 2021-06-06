public class MyAtmApplication {

  public void run(String[] args) throws InterruptedException {
    System.out.println("[Application] Starting ATM Application");
    withdrawMoney(Integer.parseInt(args[2]));

    Thread.sleep(Long.parseLong(args[1]));
    withdrawMoney(Integer.parseInt(args[3]));
  }

  private void withdrawMoney(int amount) throws InterruptedException {
    Thread.sleep(20001);
    System.out.println("[Application] Successful withdrawl of [" + amount +"] units!");
  }
}
