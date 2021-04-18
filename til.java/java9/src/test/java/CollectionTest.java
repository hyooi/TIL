import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionTest {

  /**
   * OF메소드
   * 1. 변경 불가능, 요소 추가,삭제 요청 시 exception발생
   * 2. null 불허용
   * 3. element가 직렬화가능한 경우 직렬화 가능
   * 4. 순서는 element순서와 동일
   */
  @Test
  @DisplayName("collection api 업데이트. 불변collection 생성")
  void collection() {
    var namesList = List.of("locksh", "amit", "john");
    var namesSet = Set.of("lokesh", "amit", "john");
    var namesMap = Map.ofEntries(
        Map.entry("1", "locksh"),
        Map.entry("2", "amit"),
        Map.entry("3", "john")
    );
  }
}
