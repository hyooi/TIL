package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SafeCracker {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] wn = scan.nextLine().split(" ");
    int curWeight = Integer.parseInt(wn[0]);
    int n = Integer.parseInt(wn[1]);

    // 무게당 가격이 높은 순으로 정렬.
    List<Gold> lists = new ArrayList<>();
    for (int i=0; i<n; i++) {
      String[] temp = scan.nextLine().split(" ");
      lists.add(new Gold(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
    }

    Collections.sort(lists, (g1, g2) -> Integer.compare(g2.getPrice(), g1.getPrice()));

    //   System.out.println(lists);

    int curPrice = 0;
    for (int i=0; i<n; i++) {
      Gold gold = lists.get(i);
      if (curWeight == 0) {
        break;
      }

      if (gold.getWeight() <= curWeight) {
        curWeight = curWeight - gold.getWeight();
        curPrice += gold.getWeight() * gold.getPrice();

        //   System.out.println("curWeight: " + curWeight + ", curPrice : " + curPrice);
      } else {
        curPrice += curWeight * gold.getPrice();
        curWeight = 0;
      }
    }

    System.out.println(curPrice);

    scan.close();
  }
}

class Gold {
  private int weight;
  private int price;

  public Gold(int weight, int price) {
    this.weight = weight;
    this.price = price;
  }

  public int getWeight() {
    return weight;
  }

  public int getPrice() {
    return price;
  }

  public String toString() {
    return weight + ":" + price;
  }
}
