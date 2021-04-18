import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTest {

  @Test
  @DisplayName("날짜 스트림")
  void date_stream() {
    System.out.println(getDaysInJava9(LocalDate.now(), LocalDate.now().plusDays(10)));
    System.out.println(getDaysInJava9Weeks(LocalDate.now(), LocalDate.now().plusWeeks(10)));
  }

  private List<LocalDate> getDaysInJava9(LocalDate start, LocalDate end) {
    return start.datesUntil(end)
        .collect(Collectors.toList());
  }

  private List<LocalDate> getDaysInJava9Weeks(LocalDate start, LocalDate end) {
    return start.datesUntil(end, Period.ofWeeks(1))
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("java8 날짜 스트림")
  void date_stream_java8() {
    System.out.println(getDaysInJava8(LocalDate.now(), 10));
  }

  private List<LocalDate> getDaysInJava8(LocalDate start, int days) {
    return Stream.iterate(start, date -> date.plusDays(1))
        .limit(days)
        .collect(Collectors.toList());
  }
}
