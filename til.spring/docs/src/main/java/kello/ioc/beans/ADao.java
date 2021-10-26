package kello.ioc.beans;

import java.util.Arrays;
import java.util.List;

public class ADao {

  public List<Integer> numbers() {
    return Arrays.asList(1,2,3,4,5);
  }
}
