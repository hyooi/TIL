public class MyAtm {
  public static void withdrawMoney(int amount) throws InterruptedException {
    Thread.sleep(20001);
    System.out.println("[Application] Successful withdrawl of [" + amount +"] units!");
  }
}
