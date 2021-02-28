package easy;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MakingAnagram {

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    char[] aArr = a.toCharArray();
    Set<Character> aSet = new HashSet<>();
    for (char temp : aArr) {
      aSet.add(temp);
    }

    char[] bArr = b.toCharArray();
    Set<Character> bSet = new HashSet<>();
    for (char temp : bArr) {
      bSet.add(temp);
    }

    return count(aSet, bSet)
        + count(bSet, aSet)
        + (a.length() - aSet.size())
        + (b.length() - bSet.size());
  }

  private static int count(Set<Character> str, Set<Character> list) {
    return (int) str.stream()
        .filter(s -> !list.contains(s))
        .count();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String a = scanner.nextLine();
    String b = scanner.nextLine();

    int res = makeAnagram(a, b);
    System.out.println(res);

//    bufferedWriter.write(String.valueOf(res));
//    bufferedWriter.newLine();

//    bufferedWriter.close();

    scanner.close();
  }
}
