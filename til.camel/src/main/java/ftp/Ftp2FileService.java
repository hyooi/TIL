package ftp;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultExchange;

public class Ftp2FileService {
  private final CamelContext context;
  private final ProducerTemplate template;

  public Ftp2FileService(CamelContext context, ProducerTemplate template) {
    this.context = context;
    this.template = template;
  }

  public Exchange run() throws Exception {
    context.addRoutes(new RouteBuilder() {
      @Override
      public void configure() {
        from("ftp://user@localhost?password=password")
            .to("file://D:/HK/oracle-cloud&allowNullBody=true")
            .end();
      }
    });

    return template.send("ftp://user@localhost?password=password", new DefaultExchange(context));
  }
}
