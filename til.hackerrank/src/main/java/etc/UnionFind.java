package etc;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {
  private static int[] array;

  public static void main(String[] args) {
    int size = 7;
    String[] datas = "6401352".split("");

    array = new int[size];
    for (int i=0; i<size; i++) {
      array[i] = i;
    }

    for (int i=0; i<size; i++) {
      union(i, Integer.parseInt(datas[i]));
    }

    Set<Integer> count = new HashSet<>();
    for(int a : array) {
      count.add(a);
    }

    //그룹 갯수 출력
    System.out.println(count.size());
  }

  private static void union(int a, int b) {
    a = getParent(a);
    b = getParent(b);
    if (a < b) {
      array[b] = a;
    } else {
      array[a] = b;
    }
  }

  private static int getParent(int x) {
    if (array[x] == x) {
      return x;
    }

    array[x] = getParent(array[x]);
    return array[x];
  }
}
