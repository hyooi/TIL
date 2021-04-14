package dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParseStringToDateTest {

  @Test
  @DisplayName("문자열을 iso8601형식 날짜로 변환")
  void iso8601() {
    var date = "2021-04-15";
    System.out.println("date : " + LocalDate.parse(date));

    var time = "2021-04-15T11:50";
    System.out.println("date/time : " + LocalDateTime.parse(time));
  }

  @Test
  @DisplayName("사용자지정 형식의 문자열을 날짜로 변환")
  void user_date_string() {
    var date = "2021 04 15";
    System.out.println("date : " + LocalDate.parse(date,
        DateTimeFormatter.ofPattern("yyyy MM dd")));
  }
}
