import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalTest {

  @Test
  @DisplayName("isEmpty")
  void isEmpty() {
    String temp = null;

    Assertions.assertTrue(!Optional.ofNullable(temp)
        .isPresent());
    Assertions.assertTrue(Optional.ofNullable(temp)
        .isEmpty());

    temp = "temp";

    Assertions.assertFalse(!Optional.ofNullable(temp)
        .isPresent());
    Assertions.assertFalse(Optional.ofNullable(temp)
        .isEmpty());
  }
}
