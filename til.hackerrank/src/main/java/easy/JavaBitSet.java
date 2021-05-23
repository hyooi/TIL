package easy;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {
  @FunctionalInterface
  interface CompareProsess {
    void execute();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] temp = scan.nextLine().split(" ");
    int nBits = Integer.parseInt(temp[0]);
    int operationCnt = Integer.parseInt(temp[1]);

    BitSet set1 = new BitSet(nBits);
    BitSet set2 = new BitSet(nBits);

    for(int i = 0; i<operationCnt; i++) {
      temp = scan.nextLine().split(" ");
      final int num1 = Integer.parseInt(temp[1]);
      final int num2 = Integer.parseInt(temp[2]);

      switch (temp[0]) {
        case "AND":
          process(num1,
              () -> set1.and(set2),
              () -> set2.and(set1)
          );
          break;
        case "SET":
          process(num1,
              () -> set1.set(num2),
              () -> set2.set(num2)
          );
          break;
        case "FLIP":
          process(num1,
              () -> set1.flip(num2),
              () -> set2.flip(num2)
          );

          break;
        case "OR":
          process(num1,
              () -> set1.or(set2),
              () -> set2.or(set1)
          );

          break;
        case "XOR":
          process(num1,
              () -> set1.xor(set2),
              () -> set2.xor(set1)
          );

          break;
      }

      printParam(set1,set2);
    }
  }

  private static void process(int compareOrder, CompareProsess processor1, CompareProsess processor2) {
    if(compareOrder == 1) {
      processor1.execute();
    } else {
      processor2.execute();
    }
  }

  private static void printParam(BitSet set1, BitSet set2) {
    System.out.printf("%d %d\n", set1.stream().filter(s -> true).count(),
        set2.stream().filter(s -> true).count());
  }
}
