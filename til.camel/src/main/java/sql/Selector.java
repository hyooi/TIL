package sql;

import java.util.List;
import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;

public class Selector {
  private final String sql;
  private final CamelContext context;
  private final ProducerTemplate template;

  public Selector(String sql, CamelContext context, ProducerTemplate template) {
    this.sql = sql;
    this.context = context;
    this.template = template;
  }

  public List<Map<String, Object>> run() {
    try {
      var uri = "sql:"+sql+"?dataSource=testdb";
      context.addRoutes(new RouteBuilder() {
        @Override
        public void configure() throws Exception {
          from("direct:start")
              .to(uri);
        }
      });

      var res = template.send("direct:start", exchange -> {});
      return (List< Map<String, Object>>) res.getOut().getBody();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
