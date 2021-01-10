package study.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class FlyweightFactory {

  // Implemented as Singleton.
  // See also Singleton / Implementation / Variant 1.
  private static final FlyweightFactory INSTANCE = new FlyweightFactory();
  // Shared flyweight pool.
  private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

  private FlyweightFactory() {
  }

  static FlyweightFactory getInstance() {
    return INSTANCE;
  }

  // Creating and maintaining shared flyweights.
  Flyweight getFlyweight(String key) {
    if (flyweights.containsKey(key)) {
      System.out.println("S h a r i n g a flyweight with key = " + key);
      return flyweights.get(key);
    } else {
      System.out.println("C r e a t i n g a flyweight with key = " + key);
      Flyweight flyweight = new Flyweight1(
          key); // assuming key = intrinsic state
      flyweights.put(key, flyweight);
      return flyweight;
    }
  }

  int getSize() {
    return flyweights.size();
  }
}