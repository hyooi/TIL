package study.designpattern.structural.proxy;

class Client {

  // Running the Client class as application.
  public static void main(String[] args) {
    // Creating a proxy for a real subject.
    Proxy proxy = new Proxy(new RealSubject());
    // Working through the proxy.
    System.out.println(proxy.operation());
  }
}