package easy;

import java.util.Scanner;

public class SecretMenu {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] mnk = scan.nextLine().split(" ");

    boolean result = false;
    String[] menu = scan.nextLine().split(" ");
    String[] input = scan.nextLine().split(" ");

    boolean isContinue = false;
    int order = 0;
    for (int j = 0; j < input.length; j++) {
      if (isContinue) {
        if (menu[order].equals(input[j])) {
          order++;

          if (order == menu.length) {
            result = true;
            break;
          }
        } else if(menu[order-1].equals(input[j])) {
        } else {
          isContinue = false;
          order = 0;
        }
      } else {
        if (menu[order].equals(input[j])) {
          isContinue = true;
          order++;

          if (order == menu.length) {
            result = true;
            break;
          }
        }
      }
    }

    System.out.println(result ? "secret" : "normal");

    scan.close();
  }
}
