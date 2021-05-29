package etc;

public class StringFlip {

  public static void main(String[] args) {
    System.out.println(solution("test"));
  }

  private static String solution(String test) {
    char[] result = new char[test.length()];
    for (int i = test.length() - 1, j = 0; i >= 0; i--, j++) {
      result[j] = test.charAt(i);
    }

    return new String(result);
  }
}
