import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 짧은 숫자 적용 가능(EX. 1000 = 1K, 1,000)
 */
public class NumberFormatTest {

  @Test
  @DisplayName("NumberFormat")
  void numberFormat() {
    var fmt = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
    System.out.println(fmt.format(100));
    System.out.println(fmt.format(1000));
    System.out.println(fmt.format(10000));
    System.out.println(fmt.format(100000));

    var fmtShort = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
    System.out.println(fmtShort.format(100));
    System.out.println(fmtShort.format(1000));
    System.out.println(fmtShort.format(10000));
    System.out.println(fmtShort.format(100000));
  }

  @Test
  @DisplayName("분수 NumberFormat")
  void fractional_numberFormat() {
    var fmt = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
    fmt.setMinimumFractionDigits(3);

    System.out.println(fmt.format(10000));
    System.out.println(fmt.format(10012));
    System.out.println(fmt.format(100201));
    System.out.println(fmt.format(1111111));
  }

  @Test
  @SneakyThrows
  @DisplayName("compact number파싱")
  void compact_number_parsing() {
    var fmt = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
    System.out.println(fmt.parse("100"));
    System.out.println(fmt.parse("1 thousand"));
    System.out.println(fmt.parse("10 thousand"));
    System.out.println(fmt.parse("100 thousand"));
  }
}
