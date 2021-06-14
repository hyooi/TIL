package sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.camel.spi.Registry;
import org.apache.camel.support.SimpleRegistry;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

class SelectorTest extends CamelTestSupport {
  private final EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScript("init.sql")
      .build();

  @Override
  protected Registry createCamelRegistry() {
    var reg = new SimpleRegistry();
    reg.bind("testdb", ds);

    return reg;
  }

  @Test
  void test() {
    var result = new Selector("SELECT * FROM TEMP_TABLE", context(), template()).run();
    assertEquals("1", result.get(0).get("ID"));
    assertEquals("CONTENT1", result.get(0).get("CONTENT"));
    assertEquals("2", result.get(1).get("ID"));
    assertEquals("CONTENT2", result.get(1).get("CONTENT"));
  }
}