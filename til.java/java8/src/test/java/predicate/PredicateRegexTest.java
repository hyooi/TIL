package predicate;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PredicateRegexTest {

  @Test
  @DisplayName("email 정규표현식 predicate")
  void test() {
    var emailFilter = Pattern.compile("^(.+)@example.com$")
        .asPredicate();

    var emails = Arrays.asList("alex@example.com", "bob@yahoo.com",
        "cat@google.com", "david@example.com");

    var desiredEmail = emails.stream()
        .filter(emailFilter)
        .collect(Collectors.toList());

    desiredEmail.forEach(System.out::println);
  }

  @Test
  @DisplayName("기존 matcher이용")
  void test2() {
    var emailFilter = Pattern.compile("^(.+)@example.com$");

    var emails = Arrays.asList("alex@example.com", "bob@yahoo.com",
        "cat@google.com", "david@example.com");

    for (String email : emails) {
      var matcher = emailFilter.matcher(email);
      if (matcher.matches()) {
        System.out.println(email);
      }
    }
  }
}
