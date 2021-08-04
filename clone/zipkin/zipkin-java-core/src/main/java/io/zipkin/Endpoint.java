package io.zipkin;

public final class Endpoint {


  public static Endpoint create(String serviceName, int ipv4, int port) {
   return new Endpoint(serviceName, ipv4, (short) (port & 0xffff));
  }

  public final String serviceName;
  public final int ipv4;
  public final short port;

  public Endpoint(String serviceName, int ipv4, short port) {
    this.serviceName = serviceName;
    this.ipv4 = ipv4;
    this.port = port;
  }

  @Override
  public String toString() {
    return null;
  }

  public static final class Builder {
    private String serviceName;
    private Integer ipv4;
    private Short port;

    public Builder() {}

    public Builder(Endpoint source) {
      this.serviceName = source.serviceName;
      this.ipv4 = source.ipv4;
      this.port = source.port;
    }

    public Builder ipv4(int ipv4) {
      this.ipv4 = ipv4;
      return this;
    }

    public Builder port(short port) {
      this.port = port;
      return this;
    }

    public Endpoint build() {
      return new Endpoint(this.serviceName, this.ipv4, this.port);
    }
  }
}
