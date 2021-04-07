package stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntStreamTest {

  @Test
  @DisplayName("for-each example")
  void forEachExample() {
    for (int i = 0; i < 5; i++) {
      doSomething(i);
    }

    /**
     * range : start이상 end미만의 1씩 증가한 부분 정렬된 int stream을 리턴함.
     * rnageClosed : start이상 end이하의 1씩 증가한 부분 정렬된 int stream을 리턴
     */
    IntStream.rangeClosed(0, 4)
        .forEach(IntStreamTest::doSomething);
  }

  private static void doSomething(int i) {
    System.out.println(i);
  }

  @Test
  @DisplayName("range와 close range")
  void range_close_range() {
    var stream = IntStream.range(5, 10);
    stream.forEach(System.out::println); //5,6,7,8,9

    IntStream clossedRangeStream = IntStream.rangeClosed(5, 10);
    clossedRangeStream.forEach(System.out::println); //5,6,7,8,9,10
  }

  @Test
  @DisplayName("소수 프린트")
  void filtering() {
    var stream = IntStream.range(1, 100);
    System.out.println(stream.filter(IntStreamTest::isPrime)
        .boxed()
        .collect(Collectors.toList()));
  }

  private static boolean isPrime(int i) {
    IntPredicate isDivisible = index -> i % index == 0;
    return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
  }

  @Test
  @DisplayName("intstream to collection1")
  void intStream_to_collection1() {
    var ints = IntStream.of(1, 2, 3, 4, 5)
        .boxed()
        .collect(Collectors.toList());

    System.out.println(ints);
  }

  @Test
  @DisplayName("intstream to collection2")
  void intStream_to_collection2() {
    var ints = IntStream.of(1, 2, 3, 4, 5)
        .mapToObj(Integer::valueOf)
        .collect(Collectors.toList());

    System.out.println(ints);
  }

  @Test
  @DisplayName("intstream to collection3")
  void intStream_to_collection3() {
    var ints = IntStream.of(1, 2, 3, 4, 5)
        .toArray();
    System.out.println(Arrays.toString(ints));
  }

  @Test
  @DisplayName("기본 intPredicate")
  void intPredicate() {
    IntPredicate isOdd = arg -> arg % 2 == 1;

    assertTrue(isOdd.test(9));
    assertFalse(isOdd.test(10));

    var stream = IntStream.range(1, 10);
    System.out.println(stream.filter(isOdd)
        .boxed()
        .collect(Collectors.toList()));
  }

  @Test
  @DisplayName("연결 intPredicate")
  void intPredicate2() {
    IntPredicate isOdd = arg -> arg % 2 == 1;

    var stream = IntStream.range(1, 20);
    var oddPrimes = stream.filter(isOdd.and(IntStreamTest::isPrime))
        .boxed()
        .collect(Collectors.toList());

    System.out.println(oddPrimes);
  }
}
