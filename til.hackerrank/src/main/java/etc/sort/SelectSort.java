package etc.sort;

import java.util.Arrays;

public class SelectSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{64, 34, 25, 12, 22, 11, 90};
    selectSort(numbers);
    System.out.println(Arrays.toString(numbers));
  }

  /*
  - 시간복잡도가 O(n2)
   */
  private static void selectSort(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      int min_index = i;

      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[j] < numbers[min_index]) {
          min_index = j;
        }
      }

      int temp = numbers[min_index];
      numbers[min_index] = numbers[i];
      numbers[i] = temp;
    }
  }
}
