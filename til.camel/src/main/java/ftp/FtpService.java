package ftp;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.support.DefaultExchange;

public class FtpService {
  private final String username;
  private final String hostname;
  private final String directoryName;

  private final CamelContext context;
  private final ProducerTemplate template;

  public FtpService(String username, String hostname, String directoryName,
      CamelContext context, ProducerTemplate template) {
    this.username = username;
    this.hostname = hostname;
    this.directoryName = directoryName;
    this.context = context;
    this.template = template;
  }

  public Exchange run() {
    var uri = "ftp:"+hostname+directoryName;
    return template.send(uri, new DefaultExchange(context));
  }
}
