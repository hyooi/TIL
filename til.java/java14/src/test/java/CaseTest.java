import java.time.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaseTest {

  @Test
  @DisplayName("switch case")
  void swtich_case() {
    Assertions.assertTrue(isWeekDayV1_1(DayOfWeek.MONDAY));
    Assertions.assertTrue(isWeekDayV1_2(DayOfWeek.MONDAY));
    Assertions.assertTrue(isWeekDayV2(DayOfWeek.MONDAY));
  }

  private boolean isWeekDayV1_1(DayOfWeek day) {
    return switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
      case SATURDAY, SUNDAY -> false;
    };
  }


  private boolean isWeekDayV1_2(DayOfWeek day) {
    return switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
        yield true;
      case SATURDAY, SUNDAY:
        yield false;
    };
  }

  private boolean isWeekDayV2(DayOfWeek day) {
    return switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
        System.out.println("It is Weekday");
        yield true;
      }
      case SATURDAY, SUNDAY -> {
        System.out.println("It is weekend");
        yield false;
      }
    };
  }
}
