package dateandtime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

  @Test
  @DisplayName("LocalDate")
  void local_date() {
    var localDate = LocalDate.now();
    System.out.println(localDate);
    System.out.println(localDate.getDayOfWeek());
    System.out.println(localDate.getDayOfMonth());
    System.out.println(localDate.getDayOfYear());
    System.out.println(localDate.isLeapYear());
    System.out.println(localDate.plusDays(12));
  }

  @Test
  @DisplayName("LocalTime")
  void local_time() {
    var localTime = LocalTime.of(12, 20);
    System.out.println(localTime);
    System.out.println(localTime.getHour());
    System.out.println(localTime.getMinute());
    System.out.println(localTime.getSecond());
  }

  @Test
  @DisplayName("localDateTime")
  void local_date_time() {
    var localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
    System.out.println(localDateTime.getDayOfMonth());
    System.out.println(localDateTime.getHour());
    System.out.println(localDateTime.getNano());
  }

  @Test
  @DisplayName("date offset")
  void date_offset() {
    var offsetDateTime = OffsetDateTime.now();
    System.out.println(offsetDateTime);

    offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
    System.out.println(offsetDateTime);

    offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
    System.out.println(offsetDateTime);

    var zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
    System.out.println(zonedDateTime);
  }

  @Test
  @DisplayName("instant")
  void instant() {
    var instant = Instant.now();
    System.out.println(instant);
    System.out.println(instant.plus(Duration.ofMillis(5000)));
    System.out.println(instant.minus(Duration.ofMillis(5000)));
    System.out.println(instant.minusSeconds(10));
  }

  @Test
  @DisplayName("duration")
  void duration() {
    var duration = Duration.ofMillis(5000);
    System.out.println(duration);

    duration = Duration.ofSeconds(60);
    System.out.println(duration);

    duration = Duration.ofMinutes(10);
    System.out.println(duration);

    duration = Duration.ofHours(2);
    System.out.println(duration);

    duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
    System.out.println(duration);
  }

  @Test
  @DisplayName("period")
  void period() {
    var period = Period.ofDays(6);
    System.out.println(period);

    period = Period.ofMonths(6);
    System.out.println(period);

    period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));
    System.out.println(period);
  }

  @Test
  @DisplayName("dayOfWeek")
  void dayOfWeek() {
    System.out.println(DayOfWeek.of(2));

    var day = DayOfWeek.FRIDAY;
    System.out.println(day.getValue());

    var localDate = LocalDate.now();
    System.out.println(localDate.with(DayOfWeek.MONDAY));
  }

  @Test
  @DisplayName("TemporalAdjusts")
  void temporalAdjusts() {
    var date = LocalDate.of(2013, Month.MAY, 15);

    var endOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(endOfMonth);

    var nextTue = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
    System.out.println(nextTue);
  }

  @Test
  @DisplayName("빌더패턴으로 날짜 만들기")
  void make_date_with_builder() {
    var date1 = Year.of(2013)
        .atMonth(Month.MAY)
        .atDay(15)
        .atTime(0, 0)
        .atOffset(ZoneOffset.of("+03:00"));
    System.out.println(date1);

    var date2 = OffsetDateTime.of(2013, 5, 15, 0, 0, 0, 0, ZoneOffset.of("+03:00"));
    System.out.println(date2);
  }

  @Test
  @DisplayName("clock")
  void clock() {
    var clock = Clock.systemDefaultZone();
    System.out.println(clock);
    System.out.println(clock.instant());
    System.out.println(clock.getZone());

    var anotherClock = Clock.system(ZoneId.of("Europe/Tiraspol"));
    System.out.println(anotherClock);
    System.out.println(anotherClock.instant());
    System.out.println(anotherClock.getZone());

    var forwaredClock = Clock.tick(anotherClock, Duration.ofSeconds(600));
    System.out.println(forwaredClock.instant());
  }

  @Test
  @DisplayName("zoneRule")
  void zoneRule() {
    System.out.println(ZoneRules.of(ZoneOffset.of("+02:00")).isDaylightSavings(Instant.now()));
    System.out.println(ZoneRules.of(ZoneOffset.of("+02:00")).isFixedOffset());
  }

  @Test
  @DisplayName("dateTimeFormatterBuilder")
  void dateTimeFormatterBuilder() {
    var formatterBuilder = new DateTimeFormatterBuilder();
    formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        .appendLiteral("-")
        .appendZoneOrOffsetId();

    var formatter = formatterBuilder.toFormatter();
    System.out.println(formatter.format(ZonedDateTime.now()));
  }
}
