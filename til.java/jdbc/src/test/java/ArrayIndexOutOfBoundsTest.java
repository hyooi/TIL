import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

public class ArrayIndexOutOfBoundsTest {

  @Test
  public void test() throws SQLException {
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    try (Connection conn = DriverManager.getConnection(url, "username", "password")) {
      PreparedStatement ps = conn.prepareStatement("INSERT INTO TARGET ("
          + "ID, NAME, PASSWORD, LOBDATA, NEW_DATE, COL6, COL7, COL8, COL9, COL10, "
          + "COL11, COL12, COL13, COL14, COL15, COL16, COL17, COL18, COL19, COL20, "
          + "COL21, COL22, COL23, COL24, COL25, COL26, COL27, COL28, COL29, COL30, "
          + "COL31, COL32, COL33, COL34, COL35, COL36, COL37, COL38, COL39, COL40, "
          + "COL41, COL42, COL43, COL44, COL45, COL46, COL47, COL48, COL49, COL50, "
          + "COL51) "
          + "VALUES ("
          + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
          + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
          + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
          + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
          + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
          + "'Y')");
      ps.setString(1, "4");
      ps.setString(2, "test");
      ps.setString(3, "test");
      ps.setString(4, null);
      ps.setString(5, null);
      ps.setString(6, "test");
      ps.setString(7, "test");
      ps.setString(8, "test");
      ps.setString(9, "test");
      ps.setString(10, "test");
      ps.setString(11, "test");
      ps.setString(12, "test");
      ps.setString(13, "test");
      ps.setString(14, "test");
      ps.setString(15, "test");
      ps.setString(16, "test");
      ps.setString(17, "test");
      ps.setString(18, "test");
      ps.setString(19, "test");
      ps.setString(20, "test");
      ps.setString(21, "test");
      ps.setString(22, "test");
      ps.setString(23, "test");
      ps.setString(24, "test");
      ps.setString(25, "test");
      ps.setString(26, "test");
      ps.setString(27, "test");
      ps.setString(28, "test");
      ps.setString(29, "test");
      ps.setString(30, "test");
      ps.setString(31, "test");
      ps.setString(32, "test");
      ps.setString(33, "test");
      ps.setString(34, "test");
      ps.setString(35, "test");
      ps.setString(36, "test");
      ps.setString(37, "test");
      ps.setString(38, "test");
      ps.setString(39, "test");
      ps.setString(40, "test");
      ps.setString(41, "test");
      ps.setString(42, "test");
      ps.setString(43, "test");
      ps.setString(44, "test");
      ps.setString(45, "test");
      ps.setString(46, "test");
      ps.setString(47, "test");
      ps.setString(48, "test");
      ps.setString(49, "test");
      ps.setString(50, "test");

      ParameterMetaData md = ps.getParameterMetaData();
      assertEquals(50, md.getParameterCount());
    }
  }
}
