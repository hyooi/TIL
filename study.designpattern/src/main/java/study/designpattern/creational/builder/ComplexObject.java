package study.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ComplexObject {
  private List<Product> children = new ArrayList<>();

  public String getParts() {
    Iterator<Product> i = children.iterator();
    String str = "Complex Object made up of ";
    while (i.hasNext()) {
      str += i.next().getName();
    }
    return str;
  }

  public boolean add(Product child) {
    return children.add(child);
  }
  public Iterator<Product> iterator() {
    return children.iterator();
  }
}
