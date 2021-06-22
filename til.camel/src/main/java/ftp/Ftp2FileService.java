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

  public Exchange run() {
    context.addRoutes(new RouteBuilder() {
      @Override
      public void configures() throws Exception {
        from("file:D:/HK/oracle-cloud")
          .to("file:D:/HK/oracle-cloud/temp")
          .end();
      }
    });
    
    return template.send("file:D:/HK/oracle-cloud", new DefaultExchange(context());
 }
