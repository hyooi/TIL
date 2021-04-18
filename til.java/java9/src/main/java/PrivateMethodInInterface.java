import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface PrivateMethodInInterface {
  default int addEvenNumbers(int... nums) {
    return add(n -> n%2 == 0, nums);
  }

  default int addOddNumbers(int... nums) {
    return add(n -> n%2 != 0, nums);
  }

  /**
   * private메소드 조건
   * 1. abstract불가
   * 2. 인터페이스 내부에서만 사용 가능
   * 3. private static메소드는 내부의 다른 static, non-static인터페이스 메소드에서 사용 가능
   * 4. private non-static메소드는 private static메소드에서 사용 불가
   * @param predicate
   * @param nums
   * @return
   */
  private int add(IntPredicate predicate, int... nums) {
    return IntStream.of(nums)
        .filter(predicate)
        .sum();
  }
}
