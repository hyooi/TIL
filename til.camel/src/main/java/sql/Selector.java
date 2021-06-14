package sql;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ModelCamelContext;

public class Selector {
  private final String sql;
  private final CamelContext context;
  private final ProducerTemplate template;

  public Selector(String sql, CamelContext context, ProducerTemplate template) {
    this.sql = sql;
    this.context = context;
    this.template = template;
  }

  public void run() {
    try {
      var uri = "sql:"+sql+"?dataSource=testdb";
      context.addRoutes(new RouteBuilder() {
        @Override
        public void configure() throws Exception {
          from("direct:start")
              .to(uri);
        }
      });

      var context = template.send("direct:start", exchange -> {});
      System.out.println(context.getIn().getBody());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
