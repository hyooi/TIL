package etc.sort;

import java.util.Arrays;

public class InsertSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{64, 34, 25, 12, 22, 11, 90};
    insertSort(numbers);

    System.out.println(Arrays.toString(numbers));
  }

  /*
  - 정렬된 원소들을 새로운 리스트에 담아 반환
  - 이미 정렬된 리스트를 다시 정렬하는 경우 O(n)
  - 역순으로 정렬된 리스트를 정렬하는 경우 O(n2)
   */
  private static void insertSort(int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
      int target = numbers[i];
      int j = i - 1;

      while (j >= 0 && target < numbers[j]) {
        numbers[j + 1] = numbers[j];
        j--;
      }

      numbers[j + 1] = target;
    }
  }


}
