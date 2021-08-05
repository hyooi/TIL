/**
 * 클래스를 확장한 인터페이스
 */
class Control {
  private state: any;
}

//Control의 모든 멤버를 상속함(state포함)
interface SelectableControl extends Control {
  select(): void;
}

class Button extends Control implements SelectableControl {
  select() {
  }
}

class Textbox extends Control {
  select() {}
}

//Control을 상속하지 않아 state사용 불가능
class Image2 implements SelectableControl{
  // private state : any;
  select() {
  }
}

class Location2 {}
