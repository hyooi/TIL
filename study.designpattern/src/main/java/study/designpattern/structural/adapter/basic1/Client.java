package study.designpattern.structural.adapter.basic1;

class Client {

  public static void main(String[] args) {
    Target objectAdapter = new ObjectAdapter(new Adaptee());
    System.out.println("(1) Object Adapter: " + objectAdapter.operation());

    Target classAdapter = new ClassAdapterAdaptee();
    System.out.println("(2) Class Adapter: " + classAdapter.operation());
  }
}
