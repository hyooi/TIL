import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForEach {

  @Test
  @DisplayName("forEach사용해 iterate")
  void forEach() {
    List<String> names = Arrays.asList("Alex", "Brian", "Charles");
    names.forEach(System.out::println);
  }

  @Test
  @DisplayName("Consumer action생성")
  void creatingConsumerAction() {
    List<String> names = Arrays.asList("Alex", "Brian", "Charles");
    Consumer<String> makeUpperCase = s -> System.out.println(s.toUpperCase());

    names.forEach(makeUpperCase);
  }

  @Test
  @DisplayName("map을 반복")
  void iterateMap() {
    Map<String, String> map = new HashMap<>();
    map.put("A", "Alex");
    map.put("B", "Brian");
    map.put("C", "Charles");

    map.forEach((k,v) -> System.out.println("key = " + k + ", value = " + v));
  }

  @Test
  @DisplayName("사용자지정 BiConsumer")
  void customBiConsumer() {
    BiConsumer<String, Integer> action = (a,b) -> {
      System.out.println("key is : " + a);
      System.out.println("value is : " + b);
    };

    Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);

    map.forEach(action);

  }

  @Test
  @DisplayName("stream을 사용한 foreach예제")
  void forEachOverStreamElements() {
    List<Integer> numberList = Arrays.asList(1,2,3,4,5);
    Consumer<Integer> action = System.out::println;

    numberList.stream()
        .filter(n -> n%2 == 0)
        .forEach(action);
  }

  @Test
  @DisplayName("stream을 사용한 foreachOrdered예제")
  void forEachOrderedOverStreamElements() {
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    Consumer<Integer> action = System.out::println;

    list.stream()
        .filter(n -> n%2 == 0)
        .parallel() //paralled를 사용하는경우 element의 순서를 보증하지 않으므로 forEachOrdered를 사용함
        .forEachOrdered(action);
  }
}
