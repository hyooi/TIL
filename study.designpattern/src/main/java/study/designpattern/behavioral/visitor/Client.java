package study.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

class Client {

  public static void main(String[] args) {
    List<Element> elements = new ArrayList<Element>();
    elements.add(new ElementA());
    elements.add(new ElementB());
    Visitor visitor = new Visitor1();

    for (Element element : elements) {
      element.accept(visitor);
    }
  }
}
