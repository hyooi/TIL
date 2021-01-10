package study.designpattern.structural.composite.basic2;

import java.util.Collections;
import java.util.Iterator;

abstract class Component {

  private String name;
  private long price;

  Component(String name, long price) {
    this.name = name;
    this.price = price;
  }

  String getName() {
    return name;
  }

  long getPrice() {
    return price;
  }

  boolean add(Component c) {
    return false;
  }

  Iterator<Component> iterator() {
    return Collections.emptyIterator();
  }

  int getChildCount() {
    return 0;
  }
}

class Processor extends Component {

  Processor(String name, long price) {
    super(name, price);
  }
}

class Memory extends Component {

  Memory(String name, long price) {
    super(name, price);
  }
}

class Disk extends Component {

  Disk(String name, long price) {
    super(name, price);
  }
}