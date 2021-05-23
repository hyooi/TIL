package etc.programmers;

public class CodingTest2 {

  public static void main(String[] args) {
    int[][] office = new int[][]{{5, -1, 4}, {6, 3, -1}, {2, -1, 1}};
    int r = 1;
    int c = 0;
    String[] move = new String[]{"go", "go", "right", "go", "right", "go", "left", "go"};

    int result = office[r][c];
    int direction = 0; //0:북 1:동 2:남 3:서

    for (String m : move) {
      switch (m) {
        case "go":
          if (direction == 0) {
            r = r - 1 < office.length && r - 1 >= 0 ? r = r - 1 : r;
          }

          if (direction == 1) {
            c = c + 1 < office.length && c + 1 >= 0 ? c = c + 1 : c;
          }

          if (direction == 2) {
            r = r + 1 < office.length && r + 1 >= 0 ? r = r + 1 : r;
          }

          if (direction == 3) {
            c = c - 1 < office.length && c - 1 >= 0 ? c = c - 1 : c;
          }

          result += (office[r][c] > 0 ? office[r][c] : 0);
          office[r][c] = 0;

          break;
        case "right":
          if (direction == 3) {
            direction = 0;
            break;
          }

          direction += 1;
          break;
        case "left":
          if (direction == 0) {
            direction = 3;
            break;
          }

          direction -= 1;
          break;
      }
    }

    System.out.println(result);
  }

}
