package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingComparator {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for (int i = 0; i < n; i++) {
      player[i] = new Player(scan.next(), scan.nextInt());
    }
    scan.close();

    Arrays.sort(player, checker);
    for (int i = 0; i < player.length; i++) {
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}

class Checker implements Comparator<Player> {

  // complete this method
  public int compare(Player a, Player b) {
    int result = Integer.compare(b.score, a.score);
    return result == 0 ? a.name.compareTo(b.name) : result;
  }
}

class Player {

  public String name;
  public int score;

  public Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}
