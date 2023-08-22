package easy;

import java.util.Scanner;

public class SecretMenu {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] mnk = scan.nextLine().split(" ");

    String menu = scan.nextLine();
    String input = scan.nextLine();

    boolean result = input.contains(menu);
    System.out.println(result? "secret" : "normal");

    scan.close();
  }
}
