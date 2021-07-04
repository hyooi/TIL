package etc.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest5 {

  public static String[] solution(String s) {
    String[] tempArr = s.split("");
    String tempPreStr = "";
    String tempPostStr = "";
    boolean isConcat = false;

    List<String> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      String pre = tempArr[i];
      String post = tempArr[s.length() - i - 1];

      if (isConcat) {
        tempPreStr += pre;
        tempPostStr = post + tempPostStr;

        if (tempPreStr.equals(tempPostStr)) {
          result.add(tempPreStr);
          isConcat = false;
        }
        continue;
      }

      if (pre.equals(post)) {
        result.add(pre);
      } else {
        isConcat = true;
        tempPreStr = pre;
        tempPostStr = post;
      }
    }

    return result.toArray(new String[0]);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(CodingTest5.solution("abcxyasdfasdfxyabc")));
    System.out.println(Arrays.toString(CodingTest5.solution("abcxyqwertyxyabc")));
    System.out.println(Arrays.toString(CodingTest5.solution("abcabcabcabc")));
    System.out.println(Arrays.toString(CodingTest5.solution("llttaattll")));
    System.out.println(Arrays.toString(CodingTest5.solution("zzzzzz")));
    System.out.println(Arrays.toString(CodingTest5.solution("abcdef")));
  }
}
