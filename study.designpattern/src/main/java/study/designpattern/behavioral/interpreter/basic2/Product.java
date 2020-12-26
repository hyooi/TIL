package study.designpattern.behavioral.interpreter.basic2;

interface Product {

  void operation();

  String getId();

  String getGroup();

  String getDescription();

  long getPrice();
}

class SalesProduct implements Product {

  private String id;
  private String group;
  private String description;
  private long price;

  SalesProduct(String id, String group, String description, long price) {
    this.id = id;
    this.group = group;
    this.description = description;
    this.price = price;
  }

  public void operation() {
    System.out.println("SalesProduct: Performing an operation ...");
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getGroup() {
    return group;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public long getPrice() {
    return price;
  }
}