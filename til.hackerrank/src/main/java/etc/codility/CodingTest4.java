package etc.codility;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class CodingTest4 {


  public static String solution(int N) {
    Stack<Character> chars = new Stack<>();
    chars.addAll(asList('a', 'b', 'c'));

    StringBuilder result = new StringBuilder();
    for (int i=0; i < N%3; i++) {
      result.append(chars.pop());
    }

    return result.toString();
  }

  /*
  문자가 홀수번 발생하도록 N개의 소문자
  ex. N=4 -> code, cats, uutu, xxxy
   */
  public static void main(String[] args) {
    System.out.println(solution(6));
    System.out.println(solution(7));
    System.out.println(solution(1));
  }
}
