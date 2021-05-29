package etc.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{64, 34, 25, 12, 22, 11, 90};
    bubbleSort(numbers);
    System.out.println(Arrays.toString(numbers));
  }

  /*
  - 역순으로 정렬된 리스트를 정렬할 때 가장 비효율적. O(n2). 순환 시마다 하나의 원소만 변경
  - 리스트가 이미 정렬된 경우 최선 O(n)
   */
  private static void bubbleSort(int[] numbers) {
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < numbers.length - 1; i++) {
      swapped = false;
      for (j = 0; j < numbers.length - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }
    }
  }
}
