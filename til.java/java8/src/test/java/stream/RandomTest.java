package stream;

import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTest {

  @Test
  @DisplayName("random numbers")
  void random_numbers() {
    var random = new Random();
    random.ints(5)
        .sorted()
        .forEach(System.out::println);

    System.out.println();

    random.doubles(5, 0, 0.5)
        .sorted()
        .forEach(System.out::println);

    System.out.println();

    var longs = random.longs(5)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(longs);
  }

}
