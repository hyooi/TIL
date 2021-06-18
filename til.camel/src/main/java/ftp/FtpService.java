package ftp;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultExchange;

public class FtpService {
  private final String hostname;
  private final String username;
  private final String password;
  private final String directoryName;

  private final CamelContext context;
  private final ProducerTemplate template;

  public FtpService(String hostname, String username, String password,
      String directoryName,
      CamelContext context, ProducerTemplate template) {
    this.hostname = hostname;
    this.username = username;
    this.password = password;
    this.directoryName = directoryName;
    this.context = context;
    this.template = template;
  }

  public Exchange run() throws Exception {
    var uri = "ftp:"+username+"@"+hostname+directoryName+"?password="+password+"&allowNullBody"
        + "=true&fileName=mydata-${date:now:yyyyMMdd}.txt";

    context.addRoutes(new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from(uri)
            .log("ftp producing....")
            .to("ftp:"+username+"@"+hostname+"/temp.txt?password="+password)
            .log("ftp consuming...")
            .end();
      }
    });
    return template.send(uri, new DefaultExchange(context));
  }
}
