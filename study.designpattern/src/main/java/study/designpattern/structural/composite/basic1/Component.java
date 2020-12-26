package study.designpattern.structural.composite.basic1;

import java.util.Collections;
import java.util.Iterator;

abstract class Component {

  private String name;

  Component(String name) {
    this.name = name;
  }

  abstract String operation();

  String getName() {
    return name;
  }

  boolean add(Component child) {
    return false;
  }

  Iterator<Component> iterator() {
    return Collections.<Component>emptyIterator();
  }
}