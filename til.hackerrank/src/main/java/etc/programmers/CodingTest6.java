package etc.programmers;

public class CodingTest6 {

  public static int solution(String s, String t) {
    int result = 0;
    while (s.contains(t)) {
      result++;
      int targetPos = s.indexOf(t);
      s = s.substring(0, targetPos) + s.substring(targetPos + t.length());
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(CodingTest6.solution("aabcbcd", "abc"));
    System.out.println(CodingTest6.solution("aaaaabbbbb", "ab"));
  }
}
