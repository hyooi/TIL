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
import java.util.RandomAccess;
import java.util.Set;
import java.util.Stack;

public class CodingTest4 {


  public static String solution(int N) {
    List<Character> chars = new ArrayList<>(asList('a', 'b', 'c', 'd','e', 'f', 'g', 'h','i','j',
        'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));

    Random random = new Random();
    int randomIdx = random.nextInt(chars.size());
    char randomChar = chars.get(randomIdx);
    chars.remove(randomIdx);

    StringBuilder result = new StringBuilder();
    if(N%2 == 0) {
      for(int i=0; i<N-1; i++) {
        result.append(randomChar);
      }
      result.append(chars.get(random.nextInt(chars.size())));
    } else {
      for(int i=0; i<N; i++) {
        result.append(randomChar);
      }
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
