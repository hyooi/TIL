package easy;

public class Kangaroo {
  public static String kangaroo(int x1, int v1, int x2, int v2) { //얘네는 다 10000보다 작음
    if ((x1 < x2 && v1 < v2) || (x2 < x1 && v2 < v1)) {
      return "NO";
    }

    for (int i=0; i<10000; i++) {
      if (x1 == x2) {
        return "YES";
      }

      x1 += v1;
      x2 += v2;
    }

    return "NO";
  }

  public static void main(String[] args) {
    System.out.println(kangaroo(0,  3, 4, 2)); //YES
    System.out.println(kangaroo(0,  2, 5, 3)); //NO
    System.out.println(kangaroo(21,  6, 47, 3)); //NO
    // 21 27 33 39 45 51 57 63 69 75 81 87 93...
    // 47 50 53 56 59 62 65 68 71 74 77 80 83 86 89 92 95 98...
  }
}
