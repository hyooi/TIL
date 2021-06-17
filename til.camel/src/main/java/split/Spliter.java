package split;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;

public class Spliter {
  private final CamelContext context;
  private final ProducerTemplate template;

  public Spliter(CamelContext context, ProducerTemplate template) {
    this.context = context;
    this.template = template;
  }

  public void run(Exchange exchange) throws Exception {
    context.addRoutes(new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("direct:body")
            .log("processing....")
            .setHeader("header", constant(new AtomicInteger(0)))
            .split(body().tokenize(","), (oldExchange, newExchange) -> {
              System.out.println("[Aggregater] atomic integer up!");
              newExchange.getIn().getHeader("header", AtomicInteger.class).incrementAndGet();

              return newExchange;
            })
            .stopOnException()
            .onPrepare(exchange -> {
              System.out.println("[Prepare] atomic integer up!");
              exchange.getIn().getHeader("header", AtomicInteger.class).incrementAndGet();
            })
            .process(exchange -> {
              System.out.println("[Processor] atomic integer up!");
              exchange.getIn().getHeader("header", AtomicInteger.class).incrementAndGet();

              System.out.println(exchange.getIn().getBody(String.class));
            }).end();
      }
    });

    template.send("direct:body", exchange);
  }
}
