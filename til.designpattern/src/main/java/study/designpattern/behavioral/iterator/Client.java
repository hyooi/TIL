package study.designpattern.behavioral.iterator;

class Client {

  // Running the Client class as application.
  public static void main(String[] args) {
    // Setting up an aggregate.
    Aggregate<String> aggregate = new Aggregate1<String>(3);
    aggregate.add(" ElementA ");
    aggregate.add(" ElementB ");
    aggregate.add(" ElementC ");
    //
    // Creating an iterator.
    Iterator<String> iterator = aggregate.createIterator();
    //
    System.out.println("Traversing the aggregate front-to-back:");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}