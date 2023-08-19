package easy;

public class Transmission {
  public static void main(String args[])
  {
//    Scanner scan = new Scanner(System.in);
//    String[] input = scan.nextLine().split(" ");
//    String[] input = "1 2 3 4 5 6 7 8".split(" ");
//    String[] input = "8 7 6 5 4 3 2 1".split(" ");
//    String[] input = "8 1 2 5 4 3 2 1".split(" ");
    String[] input = "8 7 5 4 3 2 1 6".split(" ");

    boolean isAscending = true;
    boolean isDescending = true;

    int before = -1;
    for (String num : input) {
      if (before == -1) {
        before = Integer.parseInt(num);
        continue;
      }

      if (isAscending) {
        if (Integer.parseInt(num) != before + 1) {
          isAscending = false;
        } else {
          before = Integer.parseInt(num);
        }
      }

      if (isDescending) {
        if (Integer.parseInt(num) != before - 1) {
          isDescending = false;
        } else {
          before = Integer.parseInt(num);
        }
      }
    }

    if (isAscending) {
      System.out.println("ascending");
    } else if (isDescending) {
      System.out.println("descending");
    } else {
      System.out.println("mixed");
    }

//    scan.close();
  }
}
