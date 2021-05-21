package easy;

public class FrogJmp {

  public static int solution(int X, int Y, int D) {
    return (Y - X) % D > 0 ? (Y - X) / D + 1 : (Y - X) / D;
  }

  public static void main(String[] args) {
    System.out.println(FrogJmp.solution(10, 85, 30));
    System.out.println(FrogJmp.solution(2, 11, 3));
  }
}
