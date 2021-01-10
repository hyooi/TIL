package study.designpattern.structural.composite.basic1;

class Leaf extends Component {

  Leaf(String name) {
    super(name);
  }

  @Override
  String operation() {
    return getName();
  }
}