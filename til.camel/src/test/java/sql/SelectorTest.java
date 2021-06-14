package sql;

import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.spi.Registry;
import org.apache.camel.support.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

class SelectorTest extends CamelTestSupport {
  private final EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScript("init.sql")
      .build();

  @Before
  void init() throws Exception {
    super.setUp();
  }

  @Override
  protected Registry createCamelRegistry() {
    var reg = new SimpleRegistry();
    reg.bind("testdb", ds);

    return reg;
  }

  @Test
  void test() {
    new Selector("SELECT ID, CONTENT FROM TEMP_TABLE", context(), template()).run();
  }
}