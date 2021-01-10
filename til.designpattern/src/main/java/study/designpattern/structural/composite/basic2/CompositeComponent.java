package study.designpattern.structural.composite.basic2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CompositeComponent extends Component {

  private List<Component> children = new ArrayList<>();

  CompositeComponent(String name, long price) {
    super(name, price);
  }

  @Override
  long getPrice() {
    long sum = super.getPrice();
    for (Component child : children) {
      sum += child.getPrice();
    }
    return sum;
  }

  @Override
  boolean add(Component child) {
    return children.add(child);
  }

  @Override
  Iterator<Component> iterator() {
    return children.iterator();
  }

  @Override
  int getChildCount() {
    return children.size();
  }
}

class Chassis extends CompositeComponent {

  Chassis(String name, long price) {
    super(name, price);
  }
}

class Mainboard extends CompositeComponent {

  Mainboard(String name, long price) {
    super(name, price);
  }
}