package study.designpattern.behavioral.strategy;

class Context {

  private Strategy strategy;

  Context(Strategy strategy) {
    this.strategy = strategy;
  }

  String operation() {
    return "Context: Delegating an algorithm to a strategy: Result = "
        + strategy.algorithm();
  }

  void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}