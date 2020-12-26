package study.designpattern.creational.abstractfactory.basic1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClientTest {

  @Test
  public void test() {
    Client client = new Client(new FactoryMock());
    assertEquals("Hello World from ProductAMock and ProductBMock!", client.operation());
  }
}
