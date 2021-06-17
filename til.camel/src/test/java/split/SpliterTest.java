package split;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

class SpliterTest extends CamelTestSupport {

  @Test
  void test() throws Exception {
    var exchange = new DefaultExchange(context());
    exchange.getIn().setBody("A,B,C,D,E");
    new Spliter(context(), template()).run(exchange);

    assertEquals(15, exchange.getIn().getHeader("header", AtomicInteger.class).get());
  }
}