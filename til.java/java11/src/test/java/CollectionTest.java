import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionTest {

  @Test
  @DisplayName("collection을 배열로 변환하기(java11)")
  void convert_collection_to_array_in_java11() {
    var names = List.of("alex", "brian", "charles");
    var namesArr = names.toArray(String[]::new);

    System.out.println(Arrays.toString(namesArr));
  }

  @Test
  @DisplayName("collection을 배열로 변환하기(java10)")
  void convert_collection_to_array_in_java10() {
    var names = List.of("alex", "brian", "charles");
    var namesArr = names.toArray(new String[names.size()]);

    System.out.println(Arrays.toString(namesArr));
  }
}
