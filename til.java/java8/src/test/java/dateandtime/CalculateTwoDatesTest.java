package dateandtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateTwoDatesTest {

  @Test
  @DisplayName("두 날짜의 차이(period)")
  void between_day_with_period() {
    var start = LocalDate.of(2014, 1, 1);
    var end = LocalDate.now();

    var diff = Period.between(start, end);
    System.out.println("difference : " + diff.getYears() + "years, " + diff.getMonths() +
        "months, " + diff.getDays() + "days");
  }

  @Test
  @DisplayName("두 날짜의 차이(ChronoUnit)")
  void between_day_with_ChronoUnit() {
    var start = LocalDate.of(2014, 1, 1);
    var end = LocalDate.now();

    System.out.println("difference : " + ChronoUnit.YEARS.between(start, end) + "years, "
        + ChronoUnit.MONTHS.between(start, end) + "months, "
        + ChronoUnit.DAYS.between(start, end) + "days");
  }

  @Test
  @DisplayName("두 시간의 차이(Duration)")
  void between_time_with_Duration() {
    var start = LocalDateTime.of(2014, 1, 1, 0, 0);
    var end = LocalDateTime.now();

    var duration = Duration.between(start, end);
    System.out.println("difference : " + duration.getNano() + "nano, "
        + duration.getSeconds() + "seconds, "
        + duration.toMillis() + "millisecond, "
        + duration.toMinutes() + "minutes, "
        + duration.toHours() + "hours");
  }

  @Test
  @DisplayName("두 시간의 차이(ChronoUnit)")
  void between_time_with_ChronoUnit() {
    var start = LocalDateTime.of(2014, 1, 1, 0, 0);
    var end = LocalDateTime.now();

    System.out.println("difference : " + ChronoUnit.NANOS.between(start, end) + "nano, "
        + ChronoUnit.SECONDS.between(start, end) + "seconds, "
        + ChronoUnit.MILLIS.between(start, end) + "millisecond, "
        + ChronoUnit.MINUTES.between(start, end) + "minutes, "
        + ChronoUnit.HOURS.between(start, end) + "hours");
  }
}
