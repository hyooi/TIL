package study.designpattern.structural.composite.basic1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Composite extends Component {

  private List<Component> children = new ArrayList<>();

  Composite(String name) {
    super(name);
  }

  @Override
  String operation() {
    Iterator<Component> it = children.iterator();
    String str = getName();

    Component child;
    while (it.hasNext()) {
      child = it.next();
      str += child.operation();
    }

    return str;
  }

  @Override
  boolean add(Component child) {
    return children.add(child);
  }

  @Override
  Iterator<Component> iterator() {
    return children.iterator();
  }
}