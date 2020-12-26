package study.designpattern.behavioral.strategy;

interface Strategy {

  int algorithm();
}

class Strategy1 implements Strategy {

  public int algorithm() {
    return 1; // return result
  }
}

class Strategy2 implements Strategy {

  public int algorithm() {
    return 2; // return result
  }
}