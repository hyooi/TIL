import lombok.Data;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InstanceOfTest {

  @Test
  @DisplayName("instanceOf")
  void instanceOf() {
    val customer = new PersonalCustomer(0, "f", "m", "l");
    if (customer instanceof PersonalCustomer pCustomer) {
      System.out.println(pCustomer.firstName);
    }
  }

  @Test
  @DisplayName("complex instanceOf")
  void complex_instanceOf() {
    val customer = new PersonalCustomer(1, "f", "m", "l");
    if (customer instanceof PersonalCustomer pCustomer && pCustomer.id > 0) {
      System.out.println(pCustomer.firstName);
    }
  }

  private interface Customer {

  }

  @Data
  private static class PersonalCustomer implements Customer {

    private final int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;

  }

  @Data
  private static class BusinessCustomer implements Customer {

    private final String legalName;
  }
}
