package kello.ioc.extension;

public class TestBean {
  private String driverClassName;
  private String url;
  private String username;
  private String password;

  public TestBean() {
    System.out.println("[TestBean] initialized.");
  }

  public void print() {
    System.out.println("[TestBean] driverClassName : " + driverClassName);
    System.out.println("[TestBean] url : " + url);
    System.out.println("[TestBean] username : " + username);
    System.out.println("[TestBean] password : " + password);
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
